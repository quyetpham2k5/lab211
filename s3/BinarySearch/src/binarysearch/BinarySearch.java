/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearch;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class IntArray {
    private int[] numbers;

    public IntArray(int size) {
        this.numbers = new int[size];
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        if (numbers != null) {
            this.numbers = numbers;
        }
    }

    // Sinh số ngẫu nhiên trong [min, max]
    public void fillRandom(int minValue, int maxValue) {
        Random rd = new Random();
        int bound = (maxValue - minValue) + 1;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = minValue + rd.nextInt(bound);
        }
    }

    // Sắp xếp bằng Bubble Sort
    public void bubbleSort() {
        boolean swapped;
        for (int i = 0; i < numbers.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Binary Search (iterative)
    public int binarySearch(int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) return mid;
            if (numbers[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arraySize = readPositiveInt(sc, "Nhập số phần tử mảng (dương): ");
        int minValue = readInt(sc, "Nhập giá trị nhỏ nhất: ");
        int maxValue;
        while (true) {
            maxValue = readInt(sc, "Nhập giá trị lớn nhất: ");
            if (maxValue >= minValue) break;
            System.out.println("max phải >= min.");
        }
        int target = readInt(sc, "Nhập số cần tìm: ");

        IntArray arr = new IntArray(arraySize);
        arr.fillRandom(minValue, maxValue);
        arr.bubbleSort();

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr.getNumbers()));
        int index = arr.binarySearch(target);
        System.out.println("Kết quả tìm kiếm: " + index);
    }

    private static int readPositiveInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                int x = Integer.parseInt(sc.nextLine().trim());
                if (x > 0) return x;
            } catch (Exception ignored) {}
            System.out.println("Vui lòng nhập số nguyên dương hợp lệ.");
        }
    }

    private static int readInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception ignored) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }
}

