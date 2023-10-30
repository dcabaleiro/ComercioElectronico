package com.minsait.comercioelectronico.excepciones;

public class FormatoErroneoException extends RuntimeException{

    public FormatoErroneoException(){
        super ("El formato proporcionado de los parámetros no es correcto");
    }

}
