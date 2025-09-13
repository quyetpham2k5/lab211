/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;


/**
 * Lớp Number theo gợi ý đề:
 * - checkin: kiểm tra chuỗi có phải số hay không (trả về Float hoặc null)
 * - isOdd/isEven: kiểm tra lẻ/chẵn (chỉ true khi là số nguyên)
 * - isPerfectSquare: kiểm tra số chính phương (chỉ true khi là số nguyên không âm)
 */
public class Number {

    // Kiểm tra và parse số thực; trả về null nếu không phải số
    public Float checkin(String floatString) {
        if (floatString == null) return null;
        try {
            return Float.parseFloat(floatString.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean isOdd(float number) {
        if (!isInteger(number)) return false;
        long n = Math.round(number);
        return n % 2 != 0;
    }

    public boolean isEven(float number) {
        if (!isInteger(number)) return false;
        long n = Math.round(number);
        return n % 2 == 0;
    }

    public boolean isPerfectSquare(float number) {
        if (!isInteger(number) || number < 0) return false;
        long n = Math.round(number);
        long root = (long) Math.sqrt(n);
        return root * root == n;
    }

    // Hỗ trợ: kiểm tra gần đúng xem có phải số nguyên (dung sai nhỏ)
    private boolean isInteger(float number) {
        return Math.abs(number - Math.round(number)) < 1e-6;
    }
}

