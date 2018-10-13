package com.mygaienko.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by enda1n on 02.06.2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Greetings {

    private Long id;
    private long timestamp;
    private String message;

}
