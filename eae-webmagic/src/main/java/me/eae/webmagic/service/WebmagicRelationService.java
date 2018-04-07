package me.eae.webmagic.service;

import me.eae.webmagic.domain.WebmagicRelationDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-04-06 11:56:49
 */
public interface WebmagicRelationService {
	
	WebmagicRelationDO get(String id);
	
	List<WebmagicRelationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WebmagicRelationDO webmagicRelation);
	
	int update(WebmagicRelationDO webmagicRelation);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
