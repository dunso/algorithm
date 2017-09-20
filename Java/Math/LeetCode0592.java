import java.util.ArrayList;
import java.util.List;

public class LeetCode0592 {
    public String fractionAddition(String expression)
    {
        if (expression == null || expression.length() == 0) {
            return expression;
        }

        expression = expression.replace("-", "+-");
        String[] factors = expression.split("\\+");

        List<Integer> numerators = new ArrayList<Integer>();
        List<Integer> denominators = new ArrayList<Integer>();

        for (int i = 0; i < factors.length; i++) {
            if ("".equals(factors[i])) {
                continue;
            }
            String[] numbers = factors[i].split("/");
            numerators.add(Integer.valueOf(numbers[0]));
            denominators.add(Integer.valueOf(numbers[1]));
        }

        int denominator = 1;
        for (int value : denominators) {
            denominator *= value;
        }

        int numerator = 0;
        for (int i = 0; i < numerators.size(); i++) {
            numerator += numerators.get(i) * (denominator / denominators.get(i));
        }

        int gcd = GCD(Math.abs(numerator), Math.abs(denominator));
        if (gcd == 0) {
            return "-1";
        }

        if (numerator > 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        return numerator / gcd + "/" + denominator / gcd;
    }

    private int GCD(int numerator, int denominator)
    {
        if (denominator == 0) {
            return numerator;
        }
        return GCD(denominator, numerator % denominator);
    }

    public static void main(String[] args)
    {
        LeetCode0592 leetcode = new LeetCode0592();
        System.out.println(leetcode.fractionAddition("1/3-1/2"));
    }
}