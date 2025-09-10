/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letter_and_character_count;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Analyzer {
    // Thuộc tính (đặt private theo nguyên tắc đóng gói)
    private String input;                       // chuỗi đầu vào
    private int characters;                     // tổng số ký tự
    private int letters;                        // tổng số chữ cái
    private HashMap<String, Integer> wordCount; // đếm số lần xuất hiện của từng từ
    private HashMap<Character, Integer> letterCount; // đếm số lần xuất hiện của từng chữ cái

    // Constructor khởi tạo
    public Analyzer() {
        wordCount = new HashMap<>();
        letterCount = new HashMap<>();
    }

    // Getter và Setter cho input
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    // Getter cho kết quả
    public int getCharacters() {
        return characters;
    }

    public int getLetters() {
        return letters;
    }

    public HashMap<String, Integer> getWordCount() {
        return wordCount;
    }

    public HashMap<Character, Integer> getLetterCount() {
        return letterCount;
    }

    // Đếm tổng số ký tự (bao gồm khoảng trắng và dấu câu)
    public void countCharacters() {
        characters = input.length();
    }

    // Đếm tổng số chữ cái và tần suất của từng chữ
    public void countLetters() {
        letters = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) { // kiểm tra có phải chữ cái không
                letters++;
                c = Character.toLowerCase(c); // đổi về chữ thường để tránh trùng H/h
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
    }

    // Đếm từ trong chuỗi bằng StringTokenizer
    public void countWords() {
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }

    // Hiển thị kết quả
    public void displayResult() {
        System.out.println("Word count: " + wordCount);
        System.out.println("Letter frequency: " + letterCount);
        System.out.println("Total letters: " + letters);
        System.out.println("Total characters: " + characters);
    }
}

