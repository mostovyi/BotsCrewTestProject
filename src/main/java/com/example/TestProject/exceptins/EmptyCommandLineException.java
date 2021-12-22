package com.example.TestProject.exceptins;

public class EmptyCommandLineException extends RuntimeException{

    public EmptyCommandLineException(String error) {
        super(error);
    }
}
