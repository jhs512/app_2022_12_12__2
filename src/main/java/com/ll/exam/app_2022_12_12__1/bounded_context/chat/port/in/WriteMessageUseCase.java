package com.ll.exam.app_2022_12_12__1.bounded_context.chat.port.in;


import java.util.UUID;

public interface WriteMessageUseCase {
    UUID write(String authorName, String content);
}
