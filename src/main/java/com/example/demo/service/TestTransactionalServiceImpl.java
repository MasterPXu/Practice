package com.example.demo.service;

import com.example.demo.mapper.SellerGoodsMapper;
import com.example.demo.mapper.UserMappper;
import com.example.demo.vo.SellerGoods;
import com.example.demo.vo.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/8/16 14:19
 */
@Service
public class TestTransactionalServiceImpl {
    @Autowired
    private UserMappper userMappper;
    @Autowired
    private SellerGoodsMapper sellerGoodsMapper;
    @Autowired
    private TestTransactionalServiceImpl service;
    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private TestTransactionalServiceImpl testTransactionalServiceImpl;

    /**
     * Propagation.NESTED情况下
     * 插入了user，rollback了seller
     * 默认传播级别下：
     * 报如下错误
     * org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only
     * 且user和seller均无插入
     * @throws Exception
     */
    @Transactional
    public void transactionsOnDifferentRollBackFor() throws Exception {
        Connection con = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
        List<User> user = getMockUser();
        userMappper.inserteUser(user.get(0));
        SellerGoods sellers = sellerGoodsFactory("peixu");
        try {
            testTransactionalServiceImpl.insertRollBackForException(sellers);
        }catch (Exception e){
            //吞了异常，不会出现null的exception，但仍然会报
            //org.springframework.transaction.UnexpectedRollbackException,并且回滚
            //因为默认内嵌事务是加入到了此事务，内嵌事务抛异常后此事务仍向下运行。
            //运行至方法结束后，发现内嵌事务回滚了，在Spring框架层抛出此异常。
            //org.springframework.transaction.support.AbstractPlatformTransactionManager.commit
            System.out.println("内嵌事务中的异常渗透出来了，在此处吞了，查看效果");
        }
        sellers.setSellerName("modify");
        insert(sellers,con);
        System.out.println("touch the end");
    }


    @Transactional(rollbackFor = Exception.class)
    public List<Connection> transactions() throws Exception {
        List<User> user = getMockUser();
        SellerGoods sellers = sellerGoodsFactory("peixu");
        //1:插入user
        System.out.println("1:插入user");
        Connection con = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
        System.out.println("1:dataSource" + sqlSession.getConfiguration().getEnvironment().getDataSource());
//        System.out.println("3:connection 是否一致" + sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection());
        userMappper.inserteUser(user.get(0));
//        System.out.println("1:connection 是否关闭" + sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection().isClosed());
        //2:插入seller
        Connection co = insert(sellers,con);
        //其实写在里面也会引起@Transactional失效，只要另起线程就会导致ThreadLocal变化。从而导致令其线程中的事务不受管控。
        new Thread(()->{
            try {
                System.out.println("新起线程插入开始");
                Connection conn = testTransactionalServiceImpl.insert(sellers,con);
                System.out.println("新起线程插入结束");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("更改属性先执行");
        sellers.setSellerName("peixu1");
        //此插入被回滚
        Connection conn = testTransactionalServiceImpl.insert(sellers,con);

        SellerGoods s = sellerGoodsFactory(null);
        //此插入被回滚
        testTransactionalServiceImpl.insert(s,con);

//        System.out.println("co.isClosed()" + co.isClosed() + "con.isClosed()" + con.isClosed());
        //3:插入user,抛出异常
//        try {
            service.insertThrow(user.get(1),con);
//        }catch (Exception e){
//
//        }
//        System.out.println("co.isClosed()" + co.isClosed() + "con.isClosed()" + con.isClosed());
//        System.out.println("查询boolean结果为: " + userMappper.testBoolean());
        return Arrays.asList(co,con);
    }



    @Transactional(propagation = Propagation.NESTED)
    public  Connection insert(SellerGoods sellers,Connection con) throws Exception{
        System.out.println("2:插入seller");
//        System.out.println( "2:dataSource" + sqlSession.getConfiguration().getEnvironment().getDataSource());
//        System.out.println("2:connection 是否一致" + sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection());
//        System.out.println("2:connection 是否关闭" + sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection().isClosed());
        sellerGoodsMapper.inserteSeller(sellers);
        return sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertRollBackForException(SellerGoods sellers) throws Exception {
        sellerGoodsMapper.inserteSeller(sellers);
        throw new Exception();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void insertThrow(User user,Connection con) throws Exception {
//        System.out.println( "3:dataSource" + sqlSession.getConfiguration().getEnvironment().getDataSource());
        System.out.println("3:插入user,抛出异常");
//        System.out.println("3:connection 是否一致" + sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection());
        userMappper.inserteUser(user);
//        System.out.println("3:connection 是否关闭" + sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection().isClosed());
        throw new Exception();
    }


    List<User> getMockUser(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("ppp");
        user1.setAge(28);
        User user2 = new User();
        user2.setName("xppp");
        user2.setAge(29);
        users.add(user1);
        users.add(user2);
        return users;
    }

    SellerGoods sellerGoodsFactory(String name){
        return Objects.isNull(name)?new SellerGoods("default") : new SellerGoods(name);
    }
}
