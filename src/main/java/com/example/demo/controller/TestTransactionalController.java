package com.example.demo.controller;

import com.example.demo.common.kafka.producer.KafkaProducer;
import com.example.demo.mapper.SellerGoodsMapper;
import com.example.demo.mapper.UserMappper;
import com.example.demo.service.TestTransactionalServiceImpl;
import com.example.demo.vo.TestEnum;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/8/16 13:59
 */
@RestController
@RequestMapping("/test")
public class TestTransactionalController {
    @Autowired
    TestTransactionalServiceImpl service;
    @Autowired
    private SellerGoodsMapper sellerGoodsMapper;
    @Autowired
    private KafkaProducer kafkaProducer;
    /**
     *	查询所有用户信息
     */
    @GetMapping("/transactional")
    public void transactional() throws Exception {
         List<Connection> list = service.transactions();

         int i = 0;
         for(Connection con : list){
            System.out.println(i + "connection is Closed" + con.isClosed());
         }
    }


    @GetMapping("/map")
    public Map<Object,Object> returnMap(){
        Map map = sellerGoodsMapper.getBaseMap();
        return map;
    }

    @GetMapping("/enum")
    public void getEnum(@RequestParam(required = false)TestEnum test){
        System.out.println(test);
    }


    @PutMapping("/kafka")
    public void putKafka(String msg){
        kafkaProducer.sendLog("Hello," + msg);
    }
    @PutMapping("/kafka_object")
    public void putKafkaObject(){
        kafkaProducer.sendObject();
    }

}
