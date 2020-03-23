package cn.kilog.cap.securityOAuth2.service;

import cn.kilog.cap.securityOAuth2.pojo.User;

public interface AuthService {
    String register(User userToAdd) throws Exception;
    String login(String username, String password);
    String refresh(String oldToken);
}
