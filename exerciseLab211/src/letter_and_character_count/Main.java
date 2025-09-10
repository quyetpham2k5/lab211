/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letter_and_character_count;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập nội dung từ bàn phím
        System.out.print("Enter your content: ");
        String input = sc.nextLine();

        // Tạo đối tượng Analyzer để xử lý
        Analyzer analyzer = new Analyzer();
        analyzer.setInput(input);

        // Gọi các hàm xử lý
        analyzer.countCharacters();  // đếm tổng số ký tự
        analyzer.countLetters();     // đếm số chữ cái và tần suất
        analyzer.countWords();       // đếm số từ

        // In kết quả ra màn hình
        analyzer.displayResult();
    }
}
