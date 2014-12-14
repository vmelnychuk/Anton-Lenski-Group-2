package org.training.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.training.model.Message;

@Component("messageService")
@Scope("prototype")
public class MessageServiceMock implements MessageService {
    private final Logger logger = Logger.getLogger(MessageServiceMock.class);
    private Map<Long, Message> messages;
    public MessageServiceMock() {
        messages = new HashMap<Long, Message>();
        messages.put(1L, new Message("vasyl_melnychk@epam.com", "vasyl_melnychk@epam.com", "test #1", "fist test message"));
        messages.put(2L, new Message("vasyl_melnychk@epam.com", "vasyl_melnychk@epam.com", "test #2", "second test message"));
        messages.put(3L, new Message("vasyl_melnychk@epam.com", "vasyl_melnychk@epam.com", "test #3", "third test message"));
    }
    public Message getMessage(Long messageId) {
        return messages.get(messageId);
    }
    public List<Message> getAllMessages() {
        List<Message> result = new ArrayList<Message>();
        for(Message messge: messages.values()) {
            result.add(messge);
        }
        return result;
    }
    @Async
    public Future<Boolean> sendMessage(Long messageId) {
        Message message = messages.get(messageId);
        logger.info("sending message" + message);
        try {
            Thread.sleep(1000L);
            message.setSent(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Boolean result = message.isSent();
        return new AsyncResult<Boolean>(result);
    }
}
