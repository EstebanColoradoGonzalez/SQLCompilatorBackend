package com.estebancoloradogonzalez.sqlcompilator.domain.record;

import com.estebancoloradogonzalez.sqlcompilator.domain.component.LexicalComponent;
import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.category.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SymbolTable {
    private static final HashMap<String, List<LexicalComponent>> TABLE = new HashMap<>();

    public static void reboot() {
        TABLE.clear();
    }

    public static void add(LexicalComponent lexicalComponent) {
        if(lexicalComponent != null && Type.SYMBOL.equals(lexicalComponent.getType())) {
            getComponents(lexicalComponent.getLexeme()).add(lexicalComponent);
        }
    }

    public static List<LexicalComponent> getComponents(String lexeme) {
        if(!TABLE.containsKey(lexeme)) {
          TABLE.put(lexeme, new ArrayList<>());
        }

        return TABLE.get(lexeme);
    }

    public static List<LexicalComponent> getComponents() {
        var components = new ArrayList<LexicalComponent>();

        TABLE.values().forEach(components::addAll);

        return components;
    }
}