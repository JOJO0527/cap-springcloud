package cn.kilog.cap.auth.feign;//package cn.kilog.cap.auth.feign;
//
//import cn.kilog.cap.auth.model.BaseUser;
//import cn.kilog.cap.auth.pojo.ResponseCode;
//import cn.kilog.cap.auth.pojo.ResponseData;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//
///**
// * Created by fp295 on 2018/4/9.
// */
//@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseUserService.HystrixClientFallback.class)
//public interface BaseUserService extends BaseUserRemoteService {
//
//    class HystrixClientFallback implements BaseUserService{
//
//        @Override
//        public ResponseData<BaseUser> getUserByUserName(@PathVariable("userName") String userName) {
//            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
//        }
//
//        @Override
//        public ResponseData<BaseUser> getUserByPhone(@PathVariable("phone") String phone) {
//            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
//        }
//    }
//}
