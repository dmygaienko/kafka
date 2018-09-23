package com.mygaienko.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by enda1n on 02.06.2018.
 */
public interface GreetingsStreams {

    String OUTPUT = "greetings-out";
    String PART_OUTPUT = "part-greetings-out";

    @Output(OUTPUT)
    MessageChannel outboundGreetings();

    @Output(PART_OUTPUT)
    MessageChannel partOutboundGreetings();
}
