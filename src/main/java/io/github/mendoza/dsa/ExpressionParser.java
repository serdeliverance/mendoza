package io.github.mendoza.dsa;

public class ExpressionParser {

    private int index;
    private String expression;

    // operators: ( ) * / + -
    // 1. parsing the expression
    // 2. parsing parenthesis expressions
    // 3. evaluating the expresion
    public double evaluate(String expression) {
        var expressionWithoutSpaces = expression.trim();
        this.index = 0;
        this.expression = expressionWithoutSpaces;

        return 0;
    }
}
