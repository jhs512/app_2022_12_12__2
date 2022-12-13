package com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.out;

import com.ll.exam.app_2022_12_12__1.bounded_context.chat.domain.model.Message;

public interface MessageSavePort {
    void save(Message message);
}
