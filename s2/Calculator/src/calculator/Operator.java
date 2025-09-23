package calculator;


public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    POWER("^"),
    EQUAL("=");

    private final String symbol;

    Operator(String symbol) { this.symbol = symbol; }

    public String getSymbol() { return symbol; }
}
