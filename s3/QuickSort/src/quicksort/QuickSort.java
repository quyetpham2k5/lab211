/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksort;



import java.util.Random;
import java.util.Scanner;


public class QuickSort {

   
    private static final String TITLE = "===== Quick Sort Program =====";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(TITLE);

            int size = readPositiveInt(scanner, "Enter number of elements (positive integer): ");
            int minValue = readInt(scanner, "Enter min value: ");
            int maxValue = readInt(scanner, "Enter max value: ");

           
            if (minValue > maxValue) {
                int tmp = minValue;
                minValue = maxValue;
                maxValue = tmp;
            }

            
            NumberArray numberArray = new NumberArray(size, minValue, maxValue);
            numberArray.generateRandomData();

           
            printArray(numberArray.getData(), "Unsorted array");

           
            quickSort(numberArray.getData(), 0, numberArray.getSize() - 1);

           
            printArray(numberArray.getData(), "Sorted array");
        } finally {
            scanner.close();
        }
    }


    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
               
                double asDouble = Double.parseDouble(line);
                if (asDouble <= 0 || asDouble != Math.floor(asDouble)) {
                    System.out.println("Invalid input. Please enter a positive INTEGER (> 0).");
                    continue;
                }
                return (int) asDouble;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private static void printArray(int[] a, String label) {
        System.out.println(label + ":");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1) sb.append(' ');
        }
        System.out.println(sb.toString());
    }

    
    private static void quickSort(int[] a, int left, int right) {
        int i = left;
        int j = right;
        int pivot = a[(left + right) >>> 1]; 

        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        if (left < j) quickSort(a, left, j);
        if (i < right) quickSort(a, i, right);
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

  
    public static class NumberArray {
        private int size;
        private int minValue;
        private int maxValue;
        private int[] data;

        public NumberArray(int size, int minValue, int maxValue) {
            this.size = size;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.data = new int[size];
        }

        public void generateRandomData() {
            Random rnd = new Random();
            int bound = (maxValue - minValue) + 1; 
            for (int i = 0; i < size; i++) {
                data[i] = minValue + rnd.nextInt(bound);
            }
        }

        // Getters & Setters
        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Size must be > 0");
            }
            this.size = size;
            this.data = new int[size];
        }

        public int getMinValue() {
            return minValue;
        }

        public void setMinValue(int minValue) {
            this.minValue = minValue;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }

        public int[] getData() {
            return data;
        }

        public void setData(int[] data) {
            if (data == null) {
                throw new IllegalArgumentException("Data cannot be null");
            }
            this.data = data;
            this.size = data.length;
        }
    }
}
