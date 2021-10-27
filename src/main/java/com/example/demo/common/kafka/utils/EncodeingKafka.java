package com.example.demo.common.kafka.utils;

import java.util.Map;

import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serializer;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/10/26 15:01
 */

public class EncodeingKafka implements Serializer<Object> {
    private String encoding = "UTF8";

    @Override
    public void configure(Map configs, boolean isKey) {

    }
    @SneakyThrows
    @Override
    public byte[] serialize(String topic, Object data) {
//        if(data.getClass().isAssignableFrom(String.class)){
//            return data == null ? null : ((String)data).getBytes(this.encoding);
//        }else{
            return BeanUtils.bean2Byte(data);
//        }
    }
    /*
     * producer调用close()方法是调用
     */
    @Override
    public void close() {
        System.out.println("EncodeingKafka is close");
    }
}