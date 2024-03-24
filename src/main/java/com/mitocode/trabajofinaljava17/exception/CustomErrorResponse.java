package com.mitocode.trabajofinaljava17.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(

        LocalDateTime dateTime,
        String message,
        String path
) {}
