package me.eae.upms.rpc.api;

//import me.eae.upms.rpc.modelUserDO;
//import me.eae.upms.rpc.modelUserOnline;
//import org.apache.shiro.session.Session;

import me.eae.upms.model.UserDO;
import me.eae.upms.model.UserOnline;

import java.util.List;


public interface SessionService {
	List<UserOnline> list();

	List<UserDO> listOnlineUser();

//	Collection<Session> sessionList();
	
	boolean forceLogout(String sessionId);
}
