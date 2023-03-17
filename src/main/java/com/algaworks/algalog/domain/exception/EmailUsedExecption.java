package com.algaworks.algalog.domain.exception;

public class EmailUsedExecption extends RuntimeException {
    public EmailUsedExecption(String message) {
        super(message);
    }
}
