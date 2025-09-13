/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your content: ");
        String input = scanner.nextLine();

        // Tạo đối tượng xử lý
        LetterCharacterCounter counter = new LetterCharacterCounter(input);

        // In kết quả đếm từ
        System.out.println(counter.countWords());

        // In kết quả đếm chữ cái
        System.out.println(counter.countLetters());

        scanner.close();
    }
}

