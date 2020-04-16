package cn.kilog.cap.auth.feign;//package cn.kilog.cap.auth.feign;
//
//import cn.kilog.cap.auth.model.BaseRole;
//import cn.kilog.cap.auth.pojo.ResponseCode;
//import cn.kilog.cap.auth.pojo.ResponseData;
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
