package me.eae.webmagic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import me.eae.webmagic.dao.WebmagicRelationDao;
import me.eae.webmagic.domain.WebmagicRelationDO;
import me.eae.webmagic.service.WebmagicRelationService;



@Service("webmagicRelationService")
public class WebmagicRelationServiceImpl implements WebmagicRelationService {
	@Autowired
	private WebmagicRelationDao webmagicRelationDao;
	
	@Override
	public WebmagicRelationDO get(String id){
		return webmagicRelationDao.get(id);
	}
	
	@Override
	public List<WebmagicRelationDO> list(Map<String, Object> map){
		return webmagicRelationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return webmagicRelationDao.count(map);
	}
	
	@Override
	public int save(WebmagicRelationDO webmagicRelation){
		return webmagicRelationDao.save(webmagicRelation);
	}
	
	@Override
	public int update(WebmagicRelationDO webmagicRelation){
		return webmagicRelationDao.update(webmagicRelation);
	}
	
	@Override
	public int remove(String id){
		return webmagicRelationDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return webmagicRelationDao.batchRemove(ids);
	}
	
}
