package com.ll.exam.app_2022_12_12__1.bounded_context.chat.domain.service;

import com.ll.exam.app_2022_12_12__1.bounded_context.chat.domain.model.Message;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.in.GetMessagesUseCase;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.out.MessageLoadPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMessagesService implements GetMessagesUseCase {
    private final MessageLoadPort messageLoadPort;

    @Override
    public List<Message> getMessages(UUID fromUuid) {
        return messageLoadPort.getMessages(fromUuid);
    }
}
