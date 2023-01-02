package com.devjocs.model;

import java.util.List;

import com.devjocs.utils.Constantes;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class RespuestaGeneral <T> extends Constantes{
	protected int code;
    protected String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected List<String> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected T response;
	public RespuestaGeneral(int code, String message, List<String> errors, T response) {
		this.code = code;
		this.message = message;
		this.errors = errors;
		this.response = response;
	}
	public RespuestaGeneral(int code, String message, List<String> errors) {
		this.code = code;
		this.message = message;
		this.errors = errors;
	}
	public RespuestaGeneral(int code, String message, T response) {
		this.code = code;
		this.message = message;
		this.response = response;
	}
	public RespuestaGeneral(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public RespuestaGeneral() {
		this.code = 400;
		this.message = RESULT_BAD_REQUEST;
	}
	
}
