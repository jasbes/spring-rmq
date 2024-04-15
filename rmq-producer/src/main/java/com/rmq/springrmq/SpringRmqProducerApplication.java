package com.rmq.springrmq;

import com.rmq.api.model.TransactionEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringRmqProducerApplication implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringRmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var transactionEvent = new TransactionEvent("Test transaction", BigDecimal.TEN);
        rabbitTemplate.convertAndSend("test.exchange", "testRouting", transactionEvent);
    }
}
