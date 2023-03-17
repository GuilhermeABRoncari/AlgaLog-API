package com.algaworks.algalog.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorProblem {
    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<thisFields> fields;

    @Data
    @AllArgsConstructor
    public static class thisFields {
        private String fieldName;
        private String fieldMessage;
    }
}
