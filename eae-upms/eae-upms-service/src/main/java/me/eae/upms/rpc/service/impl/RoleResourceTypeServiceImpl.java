package me.eae.upms.rpc.service.impl;


import me.eae.upms.dao.RoleResourceTypeDao;
import me.eae.upms.model.RoleResourceTypeDO;
import me.eae.upms.rpc.api.RoleResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RoleResourceTypeServiceImpl implements RoleResourceTypeService {
	@Autowired
	private RoleResourceTypeDao roleResourceTypeDao;
	
	@Override
	public RoleResourceTypeDO get(Long id){
		return roleResourceTypeDao.get(id);
	}
	
	@Override
	public List<RoleResourceTypeDO> list(Map<String, Object> map){
		return roleResourceTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return roleResourceTypeDao.count(map);
	}
	
	@Override
	public int save(RoleResourceTypeDO roleResourceType){
		return roleResourceTypeDao.save(roleResourceType);
	}
	
	@Override
	public int update(RoleResourceTypeDO roleResourceType){
		return roleResourceTypeDao.update(roleResourceType);
	}
	
	@Override
	public int remove(Long id){
		return roleResourceTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return roleResourceTypeDao.batchRemove(ids);
	}
	
}
