package com.estebancoloradogonzalez.sqlcompilator.domain.error;

import com.estebancoloradogonzalez.sqlcompilator.domain.error.enumerator.TypeError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ErrorManager {
    private static final HashMap<TypeError, List<Error>> ERRORS_TABLE = new HashMap<>();
    private static boolean isInitialized = false;

    private static void initialize()
    {
        if (!isInitialized)
        {
            ERRORS_TABLE.put(TypeError.LEXICON, new ArrayList<>());
            ERRORS_TABLE.put(TypeError.SYNTACTIC, new ArrayList<>());
            ERRORS_TABLE.put(TypeError.SEMANTIC, new ArrayList<>());

            isInitialized = true;
        }
    }

    public static List<Error> getErrors(TypeError error)
    {
        if(!areThereErrors(error))
        {
            return new ArrayList<>();
        }
        else if (TypeError.LEXICON.equals(error))
        {
            return ERRORS_TABLE.get(error);
        }
        else if (TypeError.SEMANTIC.equals(error))
        {
            return ERRORS_TABLE.get(error);
        }
        else if (TypeError.SYNTACTIC.equals(error))
        {
            return ERRORS_TABLE.get(error);
        }
        else
        {
            return new ArrayList<>();
        }
    }

    public static void add(Error error)
    {
        initialize();

        if (error != null)
        {
            ERRORS_TABLE.get(error.getType()).add(error);
        }
    }

    public static boolean areThereErrors(TypeError type)
    {
        return !ERRORS_TABLE.get(type).isEmpty();
    }

    public static boolean areThereErrors()
    {
        return areThereErrors(TypeError.LEXICON) || areThereErrors(TypeError.SYNTACTIC) || areThereErrors(TypeError.SEMANTIC);
    }

    public static void reboot()
    {
        isInitialized = false;
        ERRORS_TABLE.clear();
        initialize();
    }
}