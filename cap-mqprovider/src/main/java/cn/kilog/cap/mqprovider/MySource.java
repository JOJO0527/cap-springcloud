package cn.kilog.cap.mqprovider;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {
    @Output("output")
    MessageChannel output();
}
