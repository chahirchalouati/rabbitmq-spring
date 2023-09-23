package com.crcl.rabbitexchange;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {


    @RabbitListener(
            bindings = @QueueBinding(
                    exchange = @Exchange(name = "fa.crcl.exchange",type = ExchangeTypes.DIRECT),
                    value = @Queue("fa.queue.1"),
                    key = "")
    )
    public void consumer1(Message message) {
        String message1 = message.message();
        System.out.println("start receiving message from queue 1"+ message1);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    exchange = @Exchange(name = "fa.crcl.exchange"),
                    value = @Queue("fa.queue.2"))
    )
    public void consumer2(Message message) {
        String message1 = message.message();
        System.out.println("start receiving message from queue 2"+ message1);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    exchange = @Exchange(name = "fa.crcl.exchange"),
                    value = @Queue("fa.queue.3"))
    )
    public void consumer3(Message message) {
        String message1 = message.message();
        System.out.println("start receiving message from queue 3"+ message1);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    exchange = @Exchange(name = "fa.crcl.exchange"),
                    value = @Queue("fa.queue.4"))
    )
    public void consumer4(Message message) {
        String message1 = message.message();
        System.out.println("start receiving message from queue 4"+ message1);
    }
}
