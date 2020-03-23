package cn.kilog.cap.mqconsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {

    @Input("input")
    SubscribableChannel input();

//    @Input("input2")
//    SubscribableChannel input2();
//
//    @Input("input3")
//    SubscribableChannel input3();
//
//    @Input("input4")
//    SubscribableChannel input4();
//
//    @Input("input5")
//    PollableMessageSource input5();

}
