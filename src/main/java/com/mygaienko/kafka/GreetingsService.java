package com.mygaienko.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * Created by enda1n on 02.06.2018.
 */
@Service
@Slf4j
public class GreetingsService {

    private final GreetingsStreams greetingsStreams;

    public GreetingsService(GreetingsStreams greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }

    public void sendGreeting(String message, String id) {
        Greetings greetings = Greetings.builder()
                .id(Long.valueOf(id))
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();

        log.info("Sending greetings {}", greetings);

        greetingsStreams.partOutboundGreetings()
                .send(MessageBuilder
                        .withPayload(greetings)
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .build());
    }
}
