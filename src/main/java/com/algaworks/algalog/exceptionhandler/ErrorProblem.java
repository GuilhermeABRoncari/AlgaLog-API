package com.algaworks.algalog.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorProblem {
    private Integer status;
    private LocalDateTime dateTime;
    private String title;
    private List<thisFields> fields;

    @Data
    @AllArgsConstructor
    public static class thisFields {
        private String fieldName;
        private String fieldMessage;
    }
}
