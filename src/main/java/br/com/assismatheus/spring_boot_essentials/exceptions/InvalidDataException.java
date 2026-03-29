package br.com.assismatheus.spring_boot_essentials.exceptions;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}
