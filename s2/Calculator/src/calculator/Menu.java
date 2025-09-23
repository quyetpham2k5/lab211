/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;



import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final CalculatorService service = new CalculatorService();

 
    public void start() {
        while (true) {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    runNormalCalculator();
                    break;
                case 2:
                    runBmiCalculator();
                    break;
                case 3:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Please choose from 1 to 3.\n");
            }
        }
    }

    private void showMenu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
    }

    private int getChoice() {
        String raw = sc.nextLine().trim();
        try {
            return Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            return -1; 
        }
    }

  
    private void runNormalCalculator() {
        System.out.println("\n----- Normal Calculator -----");

        Double memory = readNumber("Enter number: ");

        while (true) {
            System.out.print("Enter Operator: ");
            Operator op = service.checkOperator(sc.nextLine());

            if (op == null) {
                System.out.println("Please input (+, -, *, /, ^, =)");
                continue;
            }
            if (op == Operator.EQUAL) {
                System.out.println("Result:" + memory);
                System.out.println();
                return;
            }

            Double next = readNumber("Enter number: ");

            if (op == Operator.DIVIDE && next == 0.0) {
                
                System.out.println("Cannot divide by 0");
            } else {
                memory = service.calculate(memory, op, next);
                System.out.println("Memory:" + memory);
            }
        }
    }

    
    private void runBmiCalculator() {
        System.out.println("\n----- BMI Calculator -----");

        Double weight = readNumberWithHint("Enter Weight(kg): ", "BMI is digit");
        Double heightCm = readNumberWithHint("Enter Height(cm): ", "BMI is digit");

        BMI status = service.calculateBMI(weight, heightCm);
        double hM = heightCm / 100.0;          // cm -> m
        double bmiValue = weight / (hM * hM);  // công thức BMI

        System.out.printf("BMI Number: %.2f%n", bmiValue);
        System.out.println("BMI Status: " + status);
        System.out.println();
    }

   
    private Double readNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            Double val = service.checkin(sc.nextLine());
            if (val != null) return val;
            System.out.println("Number is invalid");
        }
    }


    private Double readNumberWithHint(String prompt, String hint) {
        while (true) {
            System.out.print(prompt);
            Double val = service.checkin(sc.nextLine());
            if (val != null) return val;
            System.out.println(hint);
        }
    }
}

