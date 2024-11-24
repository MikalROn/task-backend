package com.daniel.crud.exception;

public class RecordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(long id){
        super("Registro de id" + id + "não encontrado.");
    }
    
}
