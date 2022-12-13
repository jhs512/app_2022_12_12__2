package com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.in;

import com.ll.exam.app_2022_12_12__1.bounded_context.chat.domain.model.Message;

import java.util.List;
import java.util.UUID;

public interface GetMessagesUseCase {
    List<Message> getMessages(UUID fromUuid);
}
