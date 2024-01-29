package com.pablocupertino.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//sobrecarregar
	public ObjectNotFoundException(String msg) {
		super(msg);
		
	}

}
