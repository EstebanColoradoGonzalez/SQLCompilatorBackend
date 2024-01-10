package com.estebancoloradogonzalez.sqlcompilator.domain.cache;

import lombok.Getter;

@Getter
public class Line {
    private final int lineNumber;
    private final String content;

    private Line(int lineNumber, String content) {
        this.lineNumber = lineNumber;
        this.content = content;
    }

    public static Line build(int lineNumber, String content) {
        return new Line(lineNumber, content);
    }
}
