package br.com.transportadora.exception;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadResquestException extends RuntimeException{
	public BadResquestException(String mensagem) {
		super(mensagem);
	}
}
