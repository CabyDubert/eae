package me.eae.webmagic.start;

import me.eae.webmagic.service.WebmagicRelationService;
import me.eae.webmagic.service.WebmagicUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.RedisPriorityScheduler;
import us.codecraft.webmagic.scheduler.RedisScheduler;

import java.io.FilePermission;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郝家雨 on 2018/4/5.
 */
public class SinaProcessor implements PageProcessor {

    public static final String URL_LIST = "https://weibo\\.cn/u/\\d*";
    public static final String URL_FANS_PAGE = "https://weibo\\.cn/\\d*/fans?page=\\d*";
    private static final String URL_FANS = "https://weibo\\.cn/\\d*/fans";
    private static final String URL_FOLLOW = "https://weibo\\.cn/\\d*/follow";
    private static final String URL_FOLLOW_PAGE = "https://weibo\\.cn/\\d*/follow?page=\\d*";
    private Site site = Site
            .me()
            .setDomain(".weibo.cn")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
            .addCookie("SCF", "ApzOqUNLzVE0IzUC7i-ZF3mgaM1OpIvI-QgtRTKTjNPsQhw3viKFrLN6AjYBtUmjj-YoKpJ7TsRRmfLlVl6whPM.")
            .addCookie("SUB", "_2A253wdflDeRhGeNO7lAU8S_Kyj-IHXVVTfmtrDV6PUNbktANLU7bkW1NTuQhqZS5V0uyBmocqoF_a8w9hGfPIE-_");

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex(URL_FANS).all());//粉丝url
        page.addTargetRequests(page.getHtml().links().regex(URL_FANS_PAGE).all());
        page.addTargetRequests(page.getHtml().links().regex(URL_FOLLOW).all());
        page.addTargetRequests(page.getHtml().links().regex(URL_FOLLOW_PAGE).all());
        page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
        if (page.getUrl().regex(URL_LIST).match()) {
            String info = page.getHtml().xpath("//span[@class=\"ctt\"]").$("span", "text").toString();
            page.putField("id", info.substring(0, info.indexOf(" ")));
            page.putField("sex", info.substring(info.indexOf(" "), info.indexOf("/")).trim());
            page.putField("address", info.substring(info.indexOf("/") + 1, info.length() - 1));
        }if(page.getUrl().regex(URL_FANS).match()||page.getUrl().regex(URL_FANS_PAGE).match()){
            page.putField("fans_urls",page.getHtml().links().regex(URL_LIST).all());
        }else if(page.getUrl().regex(URL_FOLLOW).match()||page.getUrl().regex(URL_FOLLOW_PAGE).match()){
            page.putField("follow_urls",page.getHtml().links().regex(URL_LIST).all());
        }



    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy("14.18.201.32",8080);
        List<Proxy> list = new ArrayList<>();
        list.add(proxy);
        SimpleProxyProvider simpleProxyProvider = new SimpleProxyProvider(list);

        HttpClientDownloader downloader = new HttpClientDownloader();
        downloader.setProxyProvider(simpleProxyProvider);

        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring/*.xml");
        WebmagicUserService webmagicUserService = (WebmagicUserService)applicationContext.getBean("webmagicUserService");
        WebmagicRelationService webmagicRelationService = (WebmagicRelationService)applicationContext.getBean("webmagicRelationService");

        SaveUserPipeline saveUserPipeline = new SaveUserPipeline();
        saveUserPipeline.setWebmagicRelationService(webmagicRelationService);
        saveUserPipeline.setWebmagicUserService(webmagicUserService);
        SinaProcessor meiZiTuProcessor = new SinaProcessor();
        Spider.create(meiZiTuProcessor)
                .setScheduler(new RedisPriorityScheduler(new JedisPool()))
                .addUrl("https://weibo.cn/u/5878659096")
                .addPipeline(saveUserPipeline)
                .run();
    }
}
