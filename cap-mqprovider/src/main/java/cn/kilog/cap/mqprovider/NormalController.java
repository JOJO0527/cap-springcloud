package cn.kilog.cap.mqprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalController {
//    @Autowired
//    private CustomRunner customRunner;
    @Autowired
    private SendService sendService;
    @RequestMapping("send")
    public void send() throws Exception {
        sendService.send("haha");
    }
}
