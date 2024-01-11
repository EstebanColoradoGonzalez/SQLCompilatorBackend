package com.estebancoloradogonzalez.sqlcompilator.domain.error;

import com.estebancoloradogonzalez.sqlcompilator.domain.error.enumerator.TypeError;
import lombok.Getter;

public class Error {
    private int lineNumber;
    private int initialPosition;
    private int finalPosition;
    private String fault;
    private String cause;
    private String solution;
    @Getter
    private TypeError type;

    private Error(int lineNumber, int initialPosition, int finalPosition, String fault, String cause, String solution, TypeError type) {
        this.lineNumber = lineNumber;
        this.initialPosition = initialPosition;
        this.finalPosition = finalPosition;
        this.fault = fault;
        this.cause = cause;
        this.solution = solution;
        this.type = type;
    }

    public static Error build(int lineNumber, int initialPosition, int finalPosition, String fault, String cause, String solution, TypeError type) {
        return new Error(lineNumber, initialPosition, finalPosition, fault, cause, solution, type);
    }

    public static Error buildLexicalError(int lineNumber, int initialPosition, int finalPosition, String fault, String cause, String solution) {
        return new Error(lineNumber, initialPosition, finalPosition, fault, cause, solution, TypeError.LEXICON);
    }

    public static Error buildSyntaxError(int lineNumber, int initialPosition, int finalPosition, String fault, String cause, String solution) {
        return new Error(lineNumber, initialPosition, finalPosition, fault, cause, solution, TypeError.SYNTACTIC);
    }

    public static Error buildSemanticError(int lineNumber, int initialPosition, int finalPosition, String fault, String cause, String solution) {
        return new Error(lineNumber, initialPosition, finalPosition, fault, cause, solution, TypeError.SEMANTIC);
    }

    public int getLineNumber() {
        if (this.lineNumber <= 0) {
            this.lineNumber = 1;
        }

        return this.lineNumber;
    }

    public int getInitialPosition() {
        if (this.initialPosition <= 0) {
            this.initialPosition = 1;
        }

        return this.initialPosition;
    }

    public int getFinalPosition() {
        if (this.finalPosition <= 0) {
            this.finalPosition = 1;
        }

        return this.finalPosition;
    }

    public String getFault() {
        if (this.fault == null) {
            this.fault = "";
        }

        return this.fault;
    }

    public String getCause() {
        if (this.cause == null) {
            this.cause = "";
        }

        return this.cause;
    }

    public String getSolution() {
        if (this.solution == null) {
            this.solution = "";
        }

        return this.solution;
    }
}