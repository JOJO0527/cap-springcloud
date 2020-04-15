package cn.kilog.cap.portal.service;

import cn.kilog.cap.manager.pojo.CapUser;

public interface UserService {

	CapUser getUserByToken(String token);
}
