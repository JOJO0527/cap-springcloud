package cn.kilog.cap.auth.feign;//package cn.kilog.cap.auth.feign;



//import java.util.List;
//
///**
// * Created by fp295 on 2018/4/17.
// */
//@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseModuleResourceService.HystrixClientFallback.class)
//public interface BaseModuleResourceService extends BaseModuleResourcesRemoteService {
//
//    class HystrixClientFallback implements BaseModuleResourceService{
//
//        @Override
//        public ResponseData<List<BaseModuleResources>> getMenusByUserId(@PathVariable("userId") String userId) {
//            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
//        }
//    }
//}
