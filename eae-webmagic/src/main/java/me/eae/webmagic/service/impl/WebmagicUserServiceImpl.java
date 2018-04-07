package me.eae.webmagic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import me.eae.webmagic.dao.WebmagicUserDao;
import me.eae.webmagic.domain.WebmagicUserDO;
import me.eae.webmagic.service.WebmagicUserService;



@Service("webmagicUserService")
public class WebmagicUserServiceImpl implements WebmagicUserService {
	@Autowired
	private WebmagicUserDao webmagicUserDao;
	
	@Override
	public WebmagicUserDO get(Integer id){
		return webmagicUserDao.get(id);
	}
	
	@Override
	public List<WebmagicUserDO> list(Map<String, Object> map){
		return webmagicUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return webmagicUserDao.count(map);
	}
	
	@Override
	public int save(WebmagicUserDO webmagicUser){
		return webmagicUserDao.save(webmagicUser);
	}
	
	@Override
	public int update(WebmagicUserDO webmagicUser){
		return webmagicUserDao.update(webmagicUser);
	}
	
	@Override
	public int remove(Integer id){
		return webmagicUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return webmagicUserDao.batchRemove(ids);
	}
	
}
