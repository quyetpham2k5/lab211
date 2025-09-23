/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;


import java.util.ArrayList;
import java.util.List;

/**
 * Giải phương trình bậc nhất/bậc hai theo yêu cầu:
 * - calculateEquation(a,b): ax + b = 0
 *   + vô nghiệm -> return null
 *   + vô số nghiệm -> return list rỗng
 *   + có nghiệm -> list chứa 1 phần tử
 *
 * - calculateQuadraticEquation(a,b,c): ax^2 + bx + c = 0
 *   + a = 0 -> gọi lại bài toán bậc nhất (b, c)
 *   + delta < 0 -> null
 *   + delta = 0 -> list 1 phần tử
 *   + delta > 0 -> list 2 phần tử x1, x2
 */
public class EquationSolver {

    public List<Float> calculateEquation(float a, float b) {
        List<Float> result = new ArrayList<>();
        if (a == 0 && b == 0) {
            return result; // vô số nghiệm: list rỗng
        } else if (a == 0) {
            return null;   // vô nghiệm
        } else {
            result.add(-b / a);
            return result;
        }
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        if (a == 0) {
            // trở thành bậc nhất: bx + c = 0
            return calculateEquation(b, c);
        }
        List<Float> result = new ArrayList<>();
        float delta = b * b - 4 * a * c;

        if (delta < 0) return null; // vô nghiệm
        if (delta == 0) {
            result.add(-b / (2 * a));
            return result;
        }
        float sqrtD = (float) Math.sqrt(delta);
        float x1 = (-b + sqrtD) / (2 * a);
        float x2 = (-b - sqrtD) / (2 * a);
        result.add(x1);
        result.add(x2);
        return result;
    }
}

