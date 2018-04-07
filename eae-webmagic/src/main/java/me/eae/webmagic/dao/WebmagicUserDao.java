package me.eae.webmagic.dao;

import me.eae.webmagic.domain.WebmagicUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-04-06 11:56:51
 */
@Mapper
public interface WebmagicUserDao {

	WebmagicUserDO get(Integer id);
	
	List<WebmagicUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WebmagicUserDO webmagicUser);
	
	int update(WebmagicUserDO webmagicUser);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
