package me.eae.upms.rpc.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by haojy on 2018/3/26.
 */
public class EaeUpmsRpcServiceApplication {

    public static void main(String []args) throws IOException {
        new ClassPathXmlApplicationContext("classpath:spring/*.xml");
        System.in.read();
    }

}
