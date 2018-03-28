package com.eae.upms.dao;

import me.eae.upms.rpc.api.MenuService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by haojy on 2018/3/22.
 */
public class MyBatisTest {
    private MenuService service;

    @Before
    public void before() {
        //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml", "classpath:spring/applicationContext-jdbc.xml"});
        //从Spring容器中根据bean的id取出我们要使用的userService对象
        service = (MenuService)ac.getBean("menuService");

    }
    @Test
    public void testMenu( ){
        System.out.println(service.get(1L));
    }

}
