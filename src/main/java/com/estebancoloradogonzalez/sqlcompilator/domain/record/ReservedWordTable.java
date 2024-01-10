package com.estebancoloradogonzalez.sqlcompilator.domain.record;

import com.estebancoloradogonzalez.sqlcompilator.domain.component.LexicalComponent;
import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.category.Category;
import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.category.Type;
import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.constant.GrammaticalCategoryConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservedWordTable {
    private static final HashMap<String, List<LexicalComponent>> TABLE = new HashMap<>();
    private static final HashMap<String, Category> RESERVED_WORLDS = buildReserveWorlds();

    private static HashMap<String, Category> buildReserveWorlds() {
        var reservedWorlds = new HashMap<String, Category>();

        reservedWorlds.put(GrammaticalCategoryConstant.SELECT, Category.SELECT);
        reservedWorlds.put(GrammaticalCategoryConstant.FROM, Category.FROM);
        reservedWorlds.put(GrammaticalCategoryConstant.WHERE, Category.WHERE);
        reservedWorlds.put(GrammaticalCategoryConstant.ASC, Category.ASC);
        reservedWorlds.put(GrammaticalCategoryConstant.DESC, Category.DESC);
        reservedWorlds.put(GrammaticalCategoryConstant.ORDER_BY, Category.ORDER_BY);
        reservedWorlds.put(GrammaticalCategoryConstant.AND, Category.AND);
        reservedWorlds.put(GrammaticalCategoryConstant.OR, Category.OR);

        return reservedWorlds;
    }

    public static void reboot() {
        TABLE.clear();
    }

    public static void add(LexicalComponent lexicalComponent) {
        if (lexicalComponent != null && isReservedWorld(lexicalComponent.getLexeme()))
        {
            lexicalComponent = LexicalComponent.buildReservedWord(lexicalComponent.getLexeme(), RESERVED_WORLDS.get(lexicalComponent.getLexeme()), lexicalComponent.getLineNumber(), lexicalComponent.getInitialPosition(), lexicalComponent.getFinalPosition());

            getComponents(lexicalComponent.getLexeme()).add(lexicalComponent);
        }
    }

    private static boolean isReservedWorld(String lexeme)
    {
        return RESERVED_WORLDS.containsKey(lexeme);
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
