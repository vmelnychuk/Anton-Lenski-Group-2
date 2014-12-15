package org.training.app;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.training.configuration.BeansConfiguration;
import org.training.model.Message;
import org.training.service.MessageService;


public class Application {
    private static final Logger logger = Logger.getLogger(Application.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        Message message = applicationContext.getBean("message", Message.class);
        logger.info(message.getMessageText());
        logger.info(message);
        
        MessageService messageService = applicationContext.getBean("messageService", MessageService.class);
        for(Message msg : messageService.getAllMessages()) {
            logger.info(msg);
        }
        for (Message msg: messageService.getAllMessages()) {
            messageService.sendMessage(msg);
        }
    }
}
