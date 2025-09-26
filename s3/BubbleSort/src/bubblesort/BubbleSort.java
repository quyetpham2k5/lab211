/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesort;



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class IntArray {
    private int[] numbers;

    public IntArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Kích thước mảng phải > 0");
        }
        this.numbers = new int[size];
    }

    
    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Mảng không được null");
        }
        this.numbers = numbers;
    }

    
    public void fillRandom(int minInclusive, int maxInclusive) {
        if (minInclusive > maxInclusive) {
            throw new IllegalArgumentException("min phải <= max");
        }
        Random rd = new Random();
        int bound = maxInclusive - minInclusive + 1;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = minInclusive + rd.nextInt(bound);
        }
    }

    
   public void bubbleSort(){
            boolean check; 
        for( int i = 0; i < numbers.length-1; i++){
            check = false;
            for (int j = 0; j <numbers.length - 1 -i; j++){
                if ( numbers[j]> numbers[j+1]){
                    int tam = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1]= tam;
                    check = true;
                    
}
}

if(!check) break;
}
}
}




























public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = readPositiveInt(sc, "Nhập số lượng phần tử mảng (số nguyên dương): ");

        IntArray data = new IntArray(n);
       
        data.fillRandom(0, n);

        
        System.out.println("Mảng trước khi sắp xếp: " + Arrays.toString(data.getNumbers()));

       
        data.bubbleSort();
        System.out.println("Mảng sau khi sắp xếp:   " + Arrays.toString(data.getNumbers()));
    }

    
    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            int x = readInt(sc, prompt);
            if (x > 0) return x;
            System.out.println("Vui lòng nhập số nguyên dương > 0.");
        }
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
    }
}
