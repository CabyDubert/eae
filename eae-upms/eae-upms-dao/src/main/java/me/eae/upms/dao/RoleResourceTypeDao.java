package me.eae.upms.dao;


import me.eae.upms.model.RoleResourceTypeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 资源类型和角色对应表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-03-15 11:07:13
 */
@Mapper
public interface RoleResourceTypeDao {

	RoleResourceTypeDO get(Long id);
	
	List<RoleResourceTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleResourceTypeDO roleResourceType);
	
	int update(RoleResourceTypeDO roleResourceType);
	
	int remove(Long id);

	int removeByRoleId(Long id);

	int batchRemove(Long[] ids);

	List<Long> listResourceTypeByRoleId(Long id);

}
