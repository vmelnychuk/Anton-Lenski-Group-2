package org.training.app;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.training.configuration.BeansConfiguration;
import org.training.model.Message;
import org.training.service.MessageService;
import org.training.service.MessageServiceMock;


public class Application {
    private static final Logger logger = Logger.getLogger(Application.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        Message message = applicationContext.getBean("message", Message.class);
        logger.info(message.getMessageText());
        logger.info(message);
        
        MessageService messageService = applicationContext.getBean("messageService", MessageServiceMock.class);
        for(Message msg : messageService.getAllMessages()) {
            logger.info(msg);
        }
        Future<Boolean> result = messageService.sendMessage(1L);
        try {
            logger.info("result " + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
