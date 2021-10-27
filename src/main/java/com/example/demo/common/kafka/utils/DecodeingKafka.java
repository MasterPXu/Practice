package com.example.demo.common.kafka.utils;

import java.util.Map;

import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;
/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/10/26 15:00
 */


public class DecodeingKafka implements Deserializer<Object>  {
    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @SneakyThrows
    @Override
    public Object deserialize(String topic, byte[] data) {
//        try{
//            return data == null ? null : new String(data, this.encoding);
//        }catch(Exception e){
            return BeanUtils.byte2Obj(data);
//        }
    }

    @Override
    public void close() {

    }
}