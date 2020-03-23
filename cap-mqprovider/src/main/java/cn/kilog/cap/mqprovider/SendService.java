package cn.kilog.cap.mqprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SendService {

    @Autowired
    private MySource mySource;

    public void send(String msg) throws Exception {
        mySource.output().send(MessageBuilder.withPayload(msg).build());
    }


}
