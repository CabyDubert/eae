package me.eae.upms.rpc.api;



import me.eae.upms.model.RoleDO;

import java.util.List;

public interface RoleService {

	RoleDO get(Long id);

	List<RoleDO> list();

	int save(RoleDO role);

	int update(RoleDO role);

	int remove(Long id);

	List<RoleDO> list(Long userId);

	int batchremove(Long[] ids);
}
