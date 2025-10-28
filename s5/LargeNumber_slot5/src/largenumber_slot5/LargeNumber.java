/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largenumber_slot5;

public class LargeNumber {

    public static String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int n1 = num1.length();
        int n2 = num2.length();
        
        for (int i = 0; i<Math.max(n1, n2); i++){
            int digit1 = i<n1? num1.charAt(i) - '0':0;
            //
            int digit2 = i<n2? num2.charAt(i) - '0':0;
            int sum = digit1 + digit2 + carry;
            carry = sum /10;
            result.append(sum % 10);
            
        }   
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        

        
            
        
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j] += product;
                if (result[i + j] >= 10) {
                    result[i + j + 1] += result[i + j] / 10;
                    result[i + j] %= 10;
                }
            }
        }

        int i = result.length - 1;
        while (i > 0 && result[i] == 0) {
            i--;
        }

        StringBuilder sb = new StringBuilder();
        for (; i >= 0; i--) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
}
