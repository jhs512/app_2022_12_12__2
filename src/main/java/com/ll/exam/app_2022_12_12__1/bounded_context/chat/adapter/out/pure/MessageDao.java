package com.ll.exam.app_2022_12_12__1.bounded_context.chat.adapter.out.pure;

import com.ll.exam.app_2022_12_12__1.bounded_context.chat.domain.model.Message;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.out.MessageLoadPort;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.out.MessageSavePort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Repository
public class MessageDao implements MessageSavePort, MessageLoadPort {
    private final List<Message> messages = new ArrayList<>();

    @Override
    public void save(Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> getMessages(UUID fromUuid) {
        if (fromUuid == null) {
            return messages;
        }

        int index = IntStream.range(0, messages.size())
                .filter(i -> messages.get(i).isLateCreated(fromUuid))
                .findFirst()
                .orElse(-1);

        return messages.subList(index + 1, messages.size());
    }
}
