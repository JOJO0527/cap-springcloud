package cn.kilog.cap.auth.feign;//package cn.kilog.cap.auth.feign;
//
//import cn.kilog.cap.auth.model.OauthClientDetails;
//import cn.kilog.cap.auth.pojo.ResponseCode;
//import cn.kilog.cap.auth.pojo.ResponseData;
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
