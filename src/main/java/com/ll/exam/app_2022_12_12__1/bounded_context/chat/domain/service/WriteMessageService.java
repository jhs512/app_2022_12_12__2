package com.ll.exam.app_2022_12_12__1.bounded_context.chat.domain.service;

import com.ll.exam.app_2022_12_12__1.bounded_context.chat.domain.model.Message;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.in.WriteMessageUseCase;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.out.MessageSavePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class WriteMessageService implements WriteMessageUseCase {
    private final MessageSavePort messageSavePort;

    @Override
    public UUID write(String authorName, String content) {
        Message message = new Message(authorName, content);

        messageSavePort.save(message);

        log.debug("message : {}", message);

        return message.getUuid();
    }
}
