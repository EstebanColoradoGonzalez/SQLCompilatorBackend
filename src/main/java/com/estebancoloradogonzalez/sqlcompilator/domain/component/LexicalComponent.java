package com.estebancoloradogonzalez.sqlcompilator.domain.component;

import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.category.Category;
import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.category.Type;
import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.constant.StringConstant;
import lombok.Getter;

public class LexicalComponent {
    private String lexeme;
    @Getter
    private Category category;
    @Getter
    private Type type;
    @Getter
    private int lineNumber;
    @Getter
    private int initialPosition;
    @Getter
    private int finalPosition;

    private LexicalComponent(String lexeme, Category category, Type type, int lineNumber, int initialPosition, int finalPosition) {
        this.lexeme = lexeme;
        this.category = category;
        this.type = type;
        this.lineNumber = lineNumber;
        this.initialPosition = initialPosition;
        this.finalPosition = finalPosition;
    }

    public static LexicalComponent buildSymbol(String lexeme, Category category, int lineNumber, int initialPosition, int finalPosition) {
        return new LexicalComponent(lexeme, category, Type.SYMBOL, lineNumber, initialPosition, finalPosition);
    }

    public static LexicalComponent buildDummy(String lexeme, Category category, int lineNumber, int initialPosition, int finalPosition) {
        return new LexicalComponent(lexeme, category, Type.DUMMY, lineNumber, initialPosition, finalPosition);
    }

    public static LexicalComponent buildLiteral(String lexeme, Category category, int lineNumber, int initialPosition, int finalPosition) {
        return new LexicalComponent(lexeme, category, Type.LITERAL, lineNumber, initialPosition, finalPosition);
    }

    public static LexicalComponent buildReservedWord(String lexeme, Category category, int lineNumber, int initialPosition, int finalPosition) {
        return new LexicalComponent(lexeme, category, Type.RESERVED_WORD, lineNumber, initialPosition, finalPosition);
    }

    public String getLexeme() {
        if(this.lexeme == null) {
            this.lexeme = "";
        }

        return this.lexeme;
    }

    @Override
    public String toString() {
        return
                "Component Type: " + getType() + StringConstant.LINE_BREAK +
                "Category: " + getCategory() + StringConstant.LINE_BREAK +
                "Lexeme: " + getLexeme() + StringConstant.LINE_BREAK +
                "Line Number: " + getLineNumber() + StringConstant.LINE_BREAK +
                "Initial Position: " + getInitialPosition() + StringConstant.LINE_BREAK +
                "Final Position: " + getFinalPosition() + StringConstant.LINE_BREAK;
    }
}