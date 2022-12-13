package com.ll.exam.app_2022_12_12__1.bounded_context.chat.adapter.in.http;

import com.ll.exam.app_2022_12_12__1.base.dto.RsData;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.domain.model.Message;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.in.GetMessagesUseCase;
import com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.in.WriteMessageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    // writeMessageUseCase 시작 //
    private final WriteMessageUseCase writeMessageUseCase;

    public record WriteMessageRequest(String authorName, String content) {
    }

    public record WriteMessageResponse(UUID uuid) {
    }

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<WriteMessageResponse> writeMessage(@RequestBody WriteMessageRequest request) {
        UUID writeUuid = writeMessageUseCase.write(request.authorName, request.content);

        return RsData.successOf(new WriteMessageResponse(writeUuid));
    }
    // writeMessageUseCase 끝 //

    // getMessagesUseCase 시작 //
    private final GetMessagesUseCase getMessagesUseCase;

    public record GetMessagesRequest(UUID fromUuid) {
    }

    public record GetMessagesResponse(List<Message> messages) {
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<GetMessagesResponse> getMessages(GetMessagesRequest request) {
        List<Message> messages = getMessagesUseCase.getMessages(request.fromUuid);

        return RsData.successOf(new GetMessagesResponse(messages));
    }
    // getMessagesUseCase 끝 //

    @GetMapping("/room")
    public String showRoom() {
        return "chat/room";
    }
}
