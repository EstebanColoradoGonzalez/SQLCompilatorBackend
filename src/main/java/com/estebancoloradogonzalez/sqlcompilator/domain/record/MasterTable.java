package com.estebancoloradogonzalez.sqlcompilator.domain.record;

import com.estebancoloradogonzalez.sqlcompilator.domain.component.LexicalComponent;
import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.category.Type;

import java.util.List;

public class MasterTable {
    public static void add(LexicalComponent component)
    {
        ReservedWordTable.add(component);
        SymbolTable.add(component);
        LiteralTable.add(component);
        DummyTable.add(component);
    }

    public static void reboot()
    {
        ReservedWordTable.reboot();
        SymbolTable.reboot();
        LiteralTable.reboot();
        DummyTable.reboot();
    }

    public static List<LexicalComponent> getComponent(Type type)
    {
        if (Type.SYMBOL.equals(type))
        {
            return SymbolTable.getComponents();
        }
        else if (Type.DUMMY.equals(type))
        {
            return DummyTable.getComponents();
        }
        else if (Type.LITERAL.equals(type))
        {
            return LiteralTable.getComponents();
        }
        else
        {
            return ReservedWordTable.getComponents();
        }
    }
}