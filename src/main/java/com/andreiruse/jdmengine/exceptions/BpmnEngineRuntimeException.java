package com.andreiruse.jdmengine.exceptions;

public class BpmnEngineRuntimeException extends RuntimeException {
    public BpmnEngineRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
