package com.example.restfuldemo.service;

import com.example.restfuldemo.pojo.Message;

import java.util.List;

/**
 * @author Lenovo
 */
public interface MessageService {
    List<Message> findAll();

    Message findOne(Long id);

    Message save(Message message);

    void delete(Long id);

    Message update(Message message);

    Message updateText(Message message);
}
