package com.deshayes.gestiondestock.handlers;

import com.deshayes.gestiondestock.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;

    private ErrorCodes code;

    private String message;

    private List<String> errors = new ArrayList<>();
}
