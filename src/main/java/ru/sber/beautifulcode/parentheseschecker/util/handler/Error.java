package ru.sber.beautifulcode.parentheseschecker.util.handler;

import lombok.Value;

@Value
public class Error {
    private String status;
    private String reason;
    private String message;
    private String timestamp;
}