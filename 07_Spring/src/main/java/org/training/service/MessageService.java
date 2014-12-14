package org.training.service;

import java.util.List;
import java.util.concurrent.Future;

import org.training.model.Message;

public interface MessageService {
    Message getMessage(Long messageId);
    List<Message> getAllMessages();
    Future<Boolean> sendMessage(Long messageId);
}
