/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package large_number;
public class LargeNumberCalculator {
    public LargeNumber add(LargeNumber a, LargeNumber b) {
        int max = Math.max(a.getLength(), b.getLength());
        int[] res = new int[max + 1];
        int carry = 0;

        for (int i = 0; i < max; i++) {
            int x = (i < a.getLength()) ? a.getDigits()[i] : 0;
            int y = (i < b.getLength()) ? b.getDigits()[i] : 0;
            int sum = x + y + carry;
            res[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) res[max] = carry;

        LargeNumber result = new LargeNumber();
        int len = (carry > 0) ? max + 1 : max;
        int[] finalDigits = new int[len];
        System.arraycopy(res, 0, finalDigits, 0, len);
        setPrivateDigits(result, finalDigits, len);
        return result;
    }

    public LargeNumber multiply(LargeNumber a, LargeNumber b) {
        int[] res = new int[a.getLength() + b.getLength()];

        for (int i = 0; i < a.getLength(); i++) {
            int carry = 0;
            for (int j = 0; j < b.getLength(); j++) {
                int temp = res[i + j] + a.getDigits()[i] * b.getDigits()[j] + carry;
                res[i + j] = temp % 10;
                carry = temp / 10;
            }
            if (carry > 0) res[i + b.getLength()] += carry;
        }

        int len = res.length;
        while (len > 1 && res[len - 1] == 0) len--;

        int[] finalDigits = new int[len];
        System.arraycopy(res, 0, finalDigits, 0, len);

        LargeNumber result = new LargeNumber();
        setPrivateDigits(result, finalDigits, len);
        return result;
    }

    // trick nhỏ để gán giá trị private cho LargeNumber (vì không có setter public)
    private void setPrivateDigits(LargeNumber obj, int[] digits, int length) {
        try {
            java.lang.reflect.Field f1 = LargeNumber.class.getDeclaredField("digits");
            java.lang.reflect.Field f2 = LargeNumber.class.getDeclaredField("length");
            f1.setAccessible(true);
            f2.setAccessible(true);
            f1.set(obj, digits);
            f2.setInt(obj, length);
        } catch (Exception e) {
            System.out.println("Internal error: " + e.getMessage());
        }
    }
}

