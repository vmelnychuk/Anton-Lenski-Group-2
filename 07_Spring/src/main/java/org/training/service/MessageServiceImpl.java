package org.training.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.training.model.Message;

@Component("messageService")
@Scope("singleton")
public class MessageServiceImpl implements MessageService {
    private final Logger logger = Logger.getLogger(MessageServiceImpl.class);
    private Map<Long, Message> messages;
    @Autowired
    private MailSender mailSender;
    public MessageServiceImpl() {
        messages = new HashMap<Long, Message>();
        messages.put(1L, new Message("vamel.test@gmail.com", "vamel.test@gmail.com", "test #1", "fist test message"));
        messages.put(2L, new Message("vasyl_melnychuk@epam.com", "vamel.test@gmail.com", "test #2", "second test message"));
        messages.put(3L, new Message("vasyl_melnychuk@epam.com", "vamel.test@gmail.com", "test #3", "third test message"));
    }
    @Async
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
    public void sendMessage(Long messageId) {
        Message message = getMessage(messageId);
        logger.info("sending message: " + message);
        send(message);
        logger.info("message sended: " + message);
    }
    private Boolean send(Message message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(message.getFromMailBox());
        mailMessage.setTo(message.getToMailBox());
        mailMessage.setSubject(message.getSubject());
        mailMessage.setText(message.getMessageText());
        mailSender.send(mailMessage);
        message.setSent(true);
        Boolean result = message.isSent();
        return result;
    }
    public void sendMessage(Message message) {
        logger.info("sending message: " + message);
        send(message);
        logger.info("message sended: " + message);
    }
}
