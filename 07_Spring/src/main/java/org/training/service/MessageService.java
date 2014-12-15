package org.training.service;

import java.util.List;

import org.training.model.Message;

public interface MessageService {
    Message getMessage(Long messageId);
    List<Message> getAllMessages();
    void sendMessage(Long messageId);
    void sendMessage(Message message);
}
