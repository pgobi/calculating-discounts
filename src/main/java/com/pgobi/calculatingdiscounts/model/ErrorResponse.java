package com.pgobi.calculatingdiscounts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorResponse {
	private boolean result;
	private HttpStatus code;
	private String message;
}