package com.example.clientes.exceptions;

public class CodigoNuloException extends Exception {

    public CodigoNuloException(String msg) {
        super(msg);
    }

    public CodigoNuloException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
