//package cn.kilog.cap.securityOAuth2.feign;
//
//import cn.kilog.cap.securityOAuth2.model.OauthClientDetails;
//import cn.kilog.cap.securityOAuth2.pojo.ResponseCode;
//import cn.kilog.cap.securityOAuth2.pojo.ResponseData;
//import org.springframework.cloud.openfeign.FeignClient;
//
//
//import java.util.List;
//
///**
// * Created by fp295 on 2018/4/9.
// */
//@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseClientService.HystrixClientFallback.class)
//public interface BaseClientService extends BaseClientRemoteService {
//
//    class HystrixClientFallback implements BaseClientService {
//
//        @Override
//        public ResponseData<List<OauthClientDetails>> getAllClient() {
//            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
//        }
//    }
//}
