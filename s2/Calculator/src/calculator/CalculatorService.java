package calculator;


public class CalculatorService {

   
    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADD:      return a + b;
            case SUBTRACT: return a - b;
            case MULTIPLY: return a * b;
            case DIVIDE:   return a / b;            // chia 0 đã chặn ở Menu
            case POWER:    return Math.pow(a, b);
            default:       throw new IllegalArgumentException("Unsupported operator");
        }
    }

    public BMI calculateBMI(double weight, double height) throws NullPointerException {
        double hM = height / 100.0;              // cm -> m
        double bmi = weight / (hM * hM);

        if (bmi < 19)  return BMI.UNDER_STANDARD;
        if (bmi < 25)  return BMI.STANDARD;
        if (bmi < 30)  return BMI.OVERWEIGHT;
        if (bmi <= 40) return BMI.FAT_SHOULD_LOSE_WEIGHT;
        return BMI.VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY;
    }

    
    public Operator checkOperator(String operator) {
        if (operator == null) return null;
        String op = operator.trim();
        if (op.isEmpty()) return null;

        switch (op) {
            case "+": return Operator.ADD;
            case "-": return Operator.SUBTRACT;
            case "*":
            case "x":
            case "X": return Operator.MULTIPLY;
            case "/": return Operator.DIVIDE;
            case "^": return Operator.POWER;
            case "=": return Operator.EQUAL;
            default:  return null;
        }
    }

   
    public Double checkin(String inputVal) {
        try {
            if (inputVal == null) throw new NullPointerException("null input");
            return Double.parseDouble(inputVal.trim());
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }
}
