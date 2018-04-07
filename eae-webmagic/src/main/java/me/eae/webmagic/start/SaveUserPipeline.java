package me.eae.webmagic.start;

import me.eae.webmagic.domain.WebmagicRelationDO;
import me.eae.webmagic.domain.WebmagicUserDO;
import me.eae.webmagic.service.WebmagicRelationService;
import me.eae.webmagic.service.WebmagicUserService;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 郝家雨 on 2018/4/6.
 */
public class SaveUserPipeline implements Pipeline {

    public void setWebmagicRelationService(WebmagicRelationService webmagicRelationService) {
        this.webmagicRelationService = webmagicRelationService;
    }

    public void setWebmagicUserService(WebmagicUserService webmagicUserService) {
        this.webmagicUserService = webmagicUserService;
    }

    private WebmagicRelationService webmagicRelationService;
    private WebmagicUserService webmagicUserService;
    @Override
    public void process(ResultItems resultItems, Task task) {

        String url = resultItems.getRequest().getUrl();
        Map<String ,Object> map = resultItems.getAll();
        System.out.println("getUrl:"+url);
        System.out.println("data:"+map);
        if(url.indexOf("/u/")>0){//信息
            Long id = Long.parseLong(url.substring(url.lastIndexOf("/")+1,url.length()-1));
            WebmagicUserDO webmagicUserDO = new WebmagicUserDO();

            webmagicUserDO.setId(id);
            String sex = map.get("sex").toString().trim();
            int num = 2;
            if("男".equals(sex)){
                num = 0;
            }else if("女".equals(sex)){
                num = 1;
            }
            webmagicUserDO.setSex(num);
            webmagicUserDO.setAddress(map.get("address").toString());
            webmagicUserDO.setNickName(map.get("id").toString());
            webmagicUserService.save(webmagicUserDO);
        }else{
            int relation_type = 0;
            List  list ;
            if(url.indexOf("follow")>0){
                relation_type = 1;
                list = (List)map.get("follow_urls");
            }else{
                list = (List)map.get("fans_urls");
            }
            Long id = Long.parseLong(url.substring(url.indexOf(".cn/")+4,url.lastIndexOf("/")));//被关注者ID
            for(int i = 0 ;i<list.size();i++){
                String u = list.get(i).toString();
                Long ids = Long.parseLong(u.substring(u.lastIndexOf("/")+1,u.length()-1));
                WebmagicRelationDO webmagicRelationDO = new WebmagicRelationDO();
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                webmagicRelationDO.setId(uuid);
                webmagicRelationDO.setRelationType(relation_type);
                webmagicRelationDO.setUserId(id);
                webmagicRelationDO.setRelationId(ids);
                webmagicRelationService.save(webmagicRelationDO);
            }
        }

    }
    public static void main(String []args){
        String url = "https://weibo.cn/u/6466888113";
        System.out.println(url.substring(url.lastIndexOf("/"),url.length()-1));
        //System.out.println(url.substring(url.indexOf(".cn/")+4,url.lastIndexOf("/")));
    }
}
