package tests;

import java.math.BigDecimal;

public class Recursion {
    
    public BigDecimal power(BigDecimal number, int n){
        BigDecimal result = new BigDecimal(1);
        for (int i = 1; i <= n; i++){
            result = result.multiply(number);
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(String.format("%.0f", new Recursion().power(2,100)));
        System.out.println(new Recursion().power(new BigDecimal(2),500));
        System.out.println(new BigDecimal(2).pow(500));
    }

}
