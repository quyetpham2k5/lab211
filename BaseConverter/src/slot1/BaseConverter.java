/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;



/**
 * Class xử lý logic chuyển đổi giữa các hệ cơ số (2, 10, 16).
 */
public class BaseConverter {

    /**
     * Hàm chuyển đổi từ hệ cơ số này sang hệ cơ số khác.
     * @param input   chuỗi số nhập vào
     * @param baseIn  hệ cơ số đầu vào (2, 10, 16)
     * @param baseOut hệ cơ số đầu ra (2, 10, 16)
     * @return kết quả sau khi đổi sang hệ baseOut
     */
    public String convert(String input, int baseIn, int baseOut) {
        // Đổi input sang số nguyên theo baseIn
        int number = Integer.parseInt(input, baseIn);
        // Chuyển từ số nguyên sang hệ baseOut
        return Integer.toString(number, baseOut).toUpperCase();
    }
}

