//package cn.kilog.cap.securityOAuth2.feign;
//
//import cn.kilog.cap.securityOAuth2.model.BaseRole;
//import cn.kilog.cap.securityOAuth2.pojo.ResponseCode;
//import cn.kilog.cap.securityOAuth2.pojo.ResponseData;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
///**
// * Created by fp295 on 2018/4/17.
// */
//@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseRoleService.HystrixClientFallback.class)
//public interface BaseRoleService extends BaseRoleRemoteService{
//
//    class HystrixClientFallback implements BaseRoleService{
//
//        @Override
//        public ResponseData<List<BaseRole>> getRoleByUserId(@PathVariable("userId") String userId) {
//            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
//        }
//    }
//}
