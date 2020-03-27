package com.example.restfuldemo.service.impl;

import com.example.restfuldemo.pojo.Message;
import com.example.restfuldemo.repository.MessageRepository;
import com.example.restfuldemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lenovo
 */
@Service
public class MessageServiceImpl implements MessageService {
   @Autowired
   private MessageRepository repository;

    @Override
    public List<Message> findAll() {
        return repository.findAll();
    }

    @Override
    public Message findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Message save(Message message) {
        return repository.save(message);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Message update(Message message) {
        return repository.update(message);
    }

    @Override
    public Message updateText(Message message) {
        return repository.updateText(message);
    }
}
