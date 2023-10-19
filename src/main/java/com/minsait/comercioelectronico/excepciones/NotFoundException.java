package com.minsait.comercioelectronico.excepciones;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super ("Precio no disponible");
    }

}
