package com.example.demo.common.kafka.utils;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/10/26 15:01
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class BeanUtils {
    private BeanUtils() {}
    /**
     * 对象序列化为byte数组
     *
     * @param obj
     * @return
     */
    public static byte[] bean2Byte(Object obj) {
        byte[] bb = null;
        try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(byteArray)){
            outputStream.writeObject(obj);
            outputStream.flush();
            bb = byteArray.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bb;
    }
    /**
     * 字节数组转为Object对象
     *
     * @param bytes
     * @return
     */
    public static Object byte2Obj(byte[] bytes) throws IOException {
        Object readObject = null;
        try (
            ByteArrayOutputStream bs=  new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(bs.toByteArray());
            ObjectInputStream inputStream = new ObjectInputStream(in)
        ){
            readObject = inputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readObject;
    }
}