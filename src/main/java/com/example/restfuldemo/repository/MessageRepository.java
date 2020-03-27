package com.example.restfuldemo.repository;

import com.example.restfuldemo.pojo.Message;

import java.util.List;

/**
 * @author Lenovo
 */
public interface MessageRepository {
    List<Message> findAll();

    Message findOne(Long id);

    Message save(Message message);

    void delete(Long id);

    Message update(Message message);

    Message updateText(Message message);
}
