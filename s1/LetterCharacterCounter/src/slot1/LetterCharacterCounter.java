/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Class xử lý logic đếm
public class LetterCharacterCounter {
    private String content;

    // Constructor
    public LetterCharacterCounter(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Đếm số lần xuất hiện của mỗi từ
    public Map<String, Integer> countWords() {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(content);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    // Đếm số lần xuất hiện của mỗi ký tự (chỉ tính chữ cái)
    public Map<Character, Integer> countLetters() {
        Map<Character, Integer> letterCount = new LinkedHashMap<>();
        for (char c : content.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        return letterCount;
    }
}
