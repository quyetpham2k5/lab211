/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package letter_and_character_count;


import java.util.*;

public class  {
    private String content;

    // Constructor
    public listarray(String content) {
        this.content = content;
    }

    // Hàm đếm số từ
    public Map<String, Integer> countWords() {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(content, " ,.!?");

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    // Hàm đếm số ký tự
    public Map<Character, Integer> countLetters() {
        Map<Character, Integer> letterCount = new LinkedHashMap<>();

        for (char c : content.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }

        return letterCount;
    }

    // Hàm hiển thị kết quả
    public void showResult() {
       
        System.out.println(countWords());
        System.out.println(countLetters());
    }

    // Main test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your content: " + "\n");
        String input = sc.nextLine();

        listarray counter = new listarray(input);
        counter.showResult();
    }
}