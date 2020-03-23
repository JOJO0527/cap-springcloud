//package cn.kilog.cap.mqprovider;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.messaging.MessageChannel;
//
//public class CustomRunner implements CommandLineRunner {
//    @Autowired
//    private MessageChannel output; // 获取name为output的binding
//    @Autowired
//    private SendService sendService;
//
//    private final String bindingName;
//
//    @Bean
//    public CustomRunner customRunner() {
//        return new CustomRunner("output");
//    }
//
//    public CustomRunner(String bindingName) {
//        this.bindingName = bindingName;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        sendService.send( "hello rocketmq!");
//    }
//}