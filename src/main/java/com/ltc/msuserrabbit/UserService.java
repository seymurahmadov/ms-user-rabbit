package com.ltc.msuserrabbit;


import com.ltc.msuserrabbit.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final RabbitTemplate rabbitTemplate;

    public UserService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void registerUser(User user) {
        // Kullanıcı kaydı işlemleri...
        System.out.println("User registered: " + user.getUsername());

        // RabbitMQ'ya mesaj gönder
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, user);
        System.out.println("Message sent to RabbitMQ: " + user.getUsername());
    }
}
