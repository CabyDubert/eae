package me.eae.webmagic.service;

import me.eae.webmagic.domain.WebmagicUserDO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by 郝家雨 on 2018/4/6.
 */
public class WebmagicRelationServiceTest {
    ApplicationContext applicationContext;
   @Before
    public void init(){
            applicationContext = new FileSystemXmlApplicationContext("classpath:spring/*.xml");
    }
    @Test
    public void get() throws Exception {
    }

    @Test
    public void list() throws Exception {

    }

    @Test
    public void count() throws Exception {
    }

    @Test
    public void save() throws Exception {
        WebmagicUserDO webmagicUserDO  = new WebmagicUserDO();
        webmagicUserDO.setId(1L);
        webmagicUserDO.setNickName("test");
        webmagicUserDO.setAddress("北京");
        webmagicUserDO.setSex(1);
        WebmagicUserService webmagicUserService = (WebmagicUserService)applicationContext.getBean("webmagicUserService");
        webmagicUserService.save(webmagicUserDO);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void batchRemove() throws Exception {
    }

}