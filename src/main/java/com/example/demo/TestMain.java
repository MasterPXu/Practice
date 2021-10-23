package com.example.demo;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.example.demo.vo.SellerGoods;
import com.example.demo.vo.TestVo;
import com.example.demo.vo.UnionManageItem;
import com.example.demo.vo.User;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/8/20 16:54
 */
public class TestMain {
    /**
     * 实例化一个registry，最核心的一个模块，相当于一个应用程序的metrics系统的容器，维护一个Map
     */
    private static final MetricRegistry metrics = new MetricRegistry();

    private static Queue<String> queue = new LinkedBlockingDeque<String>();

    /**
     * 在控制台上打印输出
     */
    private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

    public static void main(String[] args) throws InterruptedException, IOException {
//        Boolean[] b = new Boolean[2000];
//        System.out.println(b.length);
//        BigDecimal c = BigDecimal.ZERO;
//        BigDecimal d = null;
//        c.add(d);
//        Integer c = true ? 1 : 2;
//        System.out.println(c);

//        SellerGoods slg = new SellerGoods();
//        User user = new User();
//        slg.setCreditLimitDay(user.getCreditDateCount());
//        List a = new ArrayList();
//        Integer s = null;
//        Optional<Integer> optest = Optional.of(s);
//        Integer testi = Optional.ofNullable(optest.get()).orElseGet(()->new Integer(10));
//        System.out.println(testi);

//        String a = "1";
//        s.add(a);
//        s.add(a);

//        Set s = new LinkedHashSet<>();
//        System.out.println(s.isEmpty());

//        reporter.start(1, TimeUnit.SECONDS);
//
//        //实例化一个Gauge
//        Gauge<Integer> gauge = new Gauge<Integer>() {
//            @Override
//            public Integer getValue() {
//                return queue.size();
//            }
//        };
//
//        //注册到容器中
//        metrics.register(MetricRegistry.name(TestMain.class, "pending-job", "size"), gauge);
//
//        //测试JMX
//        JmxReporter jmxReporter = JmxReporter.forRegistry(metrics).build();
//        jmxReporter.start();
//
//        //模拟数据
//        for (int i=0; i<22; i++){
//            queue.add("a");
//            Thread.sleep(1000);
//        }
//        User u = new User();
//        u.setQty(BigDecimal.ZERO);
////        new TestMain().test(u);
//        System.out.println(new Date());
//        int a = 0;

//        User u = new User();
//        u.setName(null);
//        System.out.println(u.getName());
//        System.out.println(u.getName() != null);
//        Arrays.stream(UnionManageItem.values()).forEach(System.out::println);
        List<User> users = new ArrayList<>();
//        User u1 = new User();
//        User u2 = new User();
//        User u3 = new User();
//        float a = 1f;
//        Float aa = Float.valueOf(1);
//        byte[] b = aa.toString().getBytes();
//        for (byte bb :
//             b) {
//            System.out.println(bb);
//        }
//        users.add(u1);
//        users.add(u2);
//        users.add(u3);
//        users.stream().collect(Collectors.toMap(User::getName, User::getAddress));
//        users.stream().map(item ->{
//            return new User();
//        }).collect(Collectors.toList());
//
//        File file = new File("C:\\Users\\Administrator\\Desktop\\excel导出\\a.txt");
//        if(!file.exists()){
//            file.createNewFile();
//        }
        List<TestVo> testvo = new ArrayList<>();
        TestVo t1 = new TestVo(4229112L,null);
        TestVo t2 = new TestVo(4229112L,5);
        TestVo t3 = new TestVo(4229112L,5);
        TestVo t4 = new TestVo(4229112L,5);
        TestVo t5 = new TestVo(4229112L,5);
        TestVo t6 = new TestVo(4229112L,5);
        TestVo t7 = new TestVo(4229112L,5);
        TestVo t8 = new TestVo(4229112L,5);
        testvo.add(t1);
        testvo.add(t2);
        testvo.add(t3);
        testvo.add(t4);
        testvo.add(t5);
        testvo.add(t6);
        testvo.add(t7);
        testvo.add(t8);
        testvo.stream().collect(Collectors.toMap(TestVo::getFlowId, TestVo::getQuality));
    }



    void test(@Valid User user){
        System.out.println("111111");
    }
}
