package com.estebancoloradogonzalez.sqlcompilator.domain.cache;

import com.estebancoloradogonzalez.sqlcompilator.domain.transversal.constant.GrammaticalCategoryConstant;

import java.util.ArrayList;
import java.util.List;

public class SourceProgram {
    private List<Line> lines = new ArrayList<>();
    private final static SourceProgram INSTANCE = new SourceProgram();

    private SourceProgram() { }

    public static SourceProgram getSourceProgram()
    {
        return INSTANCE;
    }

    public Line getLine(int lineNumber) {
        if(lineNumber < 1) {
            throw new RuntimeException("Invalid line number");
        } else if (lineNumber > lines.size())
        {
            return Line.build(lines.size() + 1, GrammaticalCategoryConstant.END_FILE);
        }
        else
        {
            return lines.get(lineNumber - 1);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public void addLine(String content)
    {
        addLine(Line.build(getNextLineNumber(), getDefaultValue(content)));
    }

    public void addLines(List<Line> lines)
    {
        if (lines != null)
        {
            initialize();

            this.lines = lines;
        }
    }

    public void initialize() {
        lines.clear();
    }

    private void addLine(Line line)
    {
        lines.add(line);
    }

    private int getNextLineNumber()
    {
        return lines.size() + 1;
    }

    private String getDefaultValue(String text)
    {
        return (text == null) ? "" : text;
    }
}
