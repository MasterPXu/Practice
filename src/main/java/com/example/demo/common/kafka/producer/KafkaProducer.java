package com.example.demo.common.kafka.producer;

import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/10/26 13:51
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendLog(String log){
        System.err.println("向kafka中生产消息:"+log);
        kafkaTemplate.send("mykafka", log);
    }

    public void sendObject(){
        User logObject = new User();
        System.err.println("向kafka中生产消息:"+logObject);
        logObject.setName("MST_PeiXU");
        logObject.setQty(BigDecimal.ZERO);
        logObject.setAge(29);
        kafkaTemplate.send("mykafka", logObject);
    }
}