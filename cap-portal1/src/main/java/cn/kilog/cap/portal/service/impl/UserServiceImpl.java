package cn.kilog.cap.portal.service.impl;//package cn.kilog.cap.portal.service.impl;
//
//import cn.kilog.cap.common.pojo.ResponseResult;
//import cn.kilog.cap.manager.pojo.CapUser;
//import cn.kilog.cap.portal.service.UserService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
///**
// * 用户管理Service
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Value("${SSO_BASE_URL}")
//	public String SSO_BASE_URL;
//	@Value("${SSO_DOMAIN_BASE_USRL}")
//	public String SSO_DOMAIN_BASE_USRL;
//	@Value("${SSO_USER_TOKEN}")
//	private String SSO_USER_TOKEN;
//	@Value("${SSO_PAGE_LOGIN}")
//	public String SSO_PAGE_LOGIN;
//	@Value("${SSO_USER_LOGOUT}")
//	public String SSO_USER_LOGOUT;
//
//
//	@Override
//	public CapUser getUserByToken(String token) {
//		try {
//			//调用sso系统的服务，根据token取用户信息
//			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
//			//把json转换成ResponseResult
//			ResponseResult result = ResponseResult.formatToPojo(json, CapUser.class);
//			if (result.getStatus() == 200) {
//				CapUser user = (CapUser) result.getData();
//				return user;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}
