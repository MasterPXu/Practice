package com.example.demo.common.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/10/26 13:48
 */
@Component
@Slf4j
public class KafkaConsumer {
        @KafkaListener(topics = {"mykafka"})
        public void listen (ConsumerRecord<Object, Object> record, Acknowledgment acknowledgment, Consumer<?, ?> consumer){
            try {
                Object logStr =  record.value();
                System.out.println(logStr);
                acknowledgment.acknowledge();
            } catch (Exception e) {
                e.printStackTrace();
                log.error("kafka消息消费失败", e);
            }
        }
}
