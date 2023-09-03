package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Scanner;


public class StringCalculatorTest {

    @Test
    void calculator() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        assertThat(stringCalculate(input)).isEqualTo(10);
        sc.close();
    }

    int stringCalculate(String input) {
        String[] in = input.split(" ");
        int value = Integer.parseInt(in[0]);
        for(int i=1; i<in.length; i+=2) {
            String sign = in[i];
            int nextInt = Integer.parseInt(in[i+1]);
            value = calculate(value, sign, nextInt);
        }
        System.out.println(value);
        return value;
    }

    int calculate(int value, String sign, int nextInt) {

        if("+".equals(sign)) {
            value += nextInt;
        } else if("-".equals(sign)) {
            value -= nextInt;
        } else if("*".equals(sign)) {
            value *= nextInt;
        } else if("/".equals(sign)) {
            value /= nextInt;
        }
        return value;
    }

}
