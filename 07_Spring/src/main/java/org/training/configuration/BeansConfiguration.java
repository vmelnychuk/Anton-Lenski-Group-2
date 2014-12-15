package org.training.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.training.model.Message;

@Configuration
@ComponentScan("org.training.service")
@Import(MailConfig.class)
public class BeansConfiguration {
    @Bean
    @Scope("prototype")
    public Message message() {
        Message msg = new Message();
        msg.setFromMailBox("vasyl_melnychuk@epam.com");
        msg.setToMailBox("vmmelnychuk@gmail.com");
        msg.setSubject("test mail");
        msg.setMessageText("Some test text inside");
        msg.setSent(false);
        return msg;
    }
}
