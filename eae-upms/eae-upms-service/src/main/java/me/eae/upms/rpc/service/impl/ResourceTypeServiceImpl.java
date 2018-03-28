package me.eae.upms.rpc.service.impl;


import me.eae.common.modle.Tree;
import me.eae.common.utils.BuildTree;
import me.eae.upms.dao.ResourceTypeDao;
import me.eae.upms.dao.RoleResourceTypeDao;
import me.eae.upms.model.ResourceTypeDO;
import me.eae.upms.rpc.api.ResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {
	@Autowired
	private ResourceTypeDao resourceTypeDao;
	@Autowired
	private RoleResourceTypeDao roleResourceTypeDao;
	
	@Override
	public ResourceTypeDO get(Long id){
		return resourceTypeDao.get(id);
	}
	
	@Override
	public List<ResourceTypeDO> list(Map<String, Object> map){
		return resourceTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return resourceTypeDao.count(map);
	}
	
	@Override
	public int save(ResourceTypeDO resourceType){
		return resourceTypeDao.save(resourceType);
	}
	
	@Override
	public int update(ResourceTypeDO resourceType){
		return resourceTypeDao.update(resourceType);
	}
	
	@Override
	public int remove(Long id){
		return resourceTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return resourceTypeDao.batchRemove(ids);
	}

	@Override
	public Tree<ResourceTypeDO> getTree() {
		List <ResourceTypeDO> list = resourceTypeDao.list(new HashMap<>());

		List<Tree<ResourceTypeDO>> trees = new ArrayList<Tree<ResourceTypeDO>>();
		for(ResourceTypeDO resourceTypeDO:list){
			Tree<ResourceTypeDO> tree = new Tree<ResourceTypeDO>();
			tree.setId(resourceTypeDO.getId().toString());
			tree.setParentId("0");
			tree.setText(resourceTypeDO.getResourceTypeName());
			trees.add(tree);
		}
		Tree<ResourceTypeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<ResourceTypeDO> getTree(Long roleId) {
		//获取全部列表
		List <ResourceTypeDO> list = resourceTypeDao.list(new HashMap<>());

		//获取
		List <Long> roleRes = roleResourceTypeDao.listResourceTypeByRoleId(roleId);
		List<Tree<ResourceTypeDO>> trees = new ArrayList<Tree<ResourceTypeDO>>();
		for(ResourceTypeDO resourceTypeDO :list){
			Tree<ResourceTypeDO> tree = new Tree<>();
			tree.setId(resourceTypeDO.getId().toString());
			tree.setParentId("0");
			tree.setText(resourceTypeDO.getResourceTypeName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("selected", false);
			for(Long roleID :roleRes){
				if(roleID.equals(resourceTypeDO.getId())){
					state.put("selected", true);
					break;
				}
			}
			tree.setState(state);
			trees.add(tree);
		}
		Tree<ResourceTypeDO> t = BuildTree.build(trees);
		return t;
	}

}
