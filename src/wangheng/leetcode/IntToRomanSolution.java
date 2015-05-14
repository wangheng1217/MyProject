package wangheng.leetcode;

public class IntToRomanSolution {
    public String intToRoman4(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return new StringBuilder().append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]).toString();
    }

    public String intToRoman2(int num) {
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int times = num / nums[i];
            num -= nums[i] * times;
            for (; times > 0; times--) {
                res.append(symbols[i]);
            }
            ++i;
        }
        return res.toString();
    }
    
    public String intToRoman3(int num) {
        String[] romans = {"I", "V", "X", "L", "C", "D", "M", "", ""};
        String result = "";
        for (int i = 0; i < 4 && num > 0; i++) {
            int digit = num%10;
            
            result = digitToRoman(digit, romans[i*2], romans[i*2+1], romans[i*2+2]) + result;
            
            num = num/10;
        }
        return result;
    }
    
    private String digitToRoman(int digit, String one, String five, String ten) {
        String roman = null;
        switch (digit) {
            case 1:
                roman = one;
                break;
            case 2:
                roman = one + one;
                break;
            case 3:
                roman = one + one + one;
                break;
            case 4:
                roman = one + five;
                break;
            case 5:
                roman = five;
                break;
            case 6:
                roman = five + one;
                break;
            case 7:
                roman = five + one + one;
                break;
            case 8:
                roman = five + one + one + one;
                break;
            case 9:
                roman = one + ten;
                break;
            case 0:
                roman = "";
                break;
            default:
                roman = "";
                break;
        }
        return roman;
    }


    // Input is guaranteed to be within the range from 1 to 3999
    public String intToRoman(int num) {
        String roman = "";
        for (int i = 1; i <= 4 && num > 0; i++) {
            String s = convert(num % 10, i);
            roman = s + roman;
            num = num / 10;
        }
        return roman;
    }

    // num from 0 to 9
    private String convert(int num, int position) {
        String one = null, five = null, ten = null;
        if (position == 1) {
            one = "I";
            five = "V";
            ten = "X";
        } else if (position == 2) {
            one = "X";
            five = "L";
            ten = "C";
        } else if (position == 3) {
            one = "C";
            five = "D";
            ten = "M";
        } else if (position == 4) {
            one = "M";
            five = null;
            ten = null;
        }

        switch (num) {
        case 0:
            return "";
        case 1:
            return one;
        case 2:
            return one + one;
        case 3:
            return one + one + one;
        case 4:
            return one + five;
        case 5:
            return five;
        case 6:
            return five + one;
        case 7:
            return five + one + one;
        case 8:
            return five + one + one + one;
        case 9:
            return one + ten;
        default:
            return "";
        }
    }

}
