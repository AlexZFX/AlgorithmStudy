package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/7/26 13:54
 * Description : 8
 * 字符串转整数 (atoi)
 */
public class MyAtoi {

    public static void main(String[] args) {
        MyAtoi atoi = new MyAtoi();
        System.out.println(atoi.myAtoi("-5-"));
    }

    //网上解法
    public int myAtoi(String str) {
        int index = 0;
        long out = 0;
        boolean positive = true;
        while (index < str.length() && str.charAt(index) == ' ') {
            ++index;
        }
        if (index < str.length() && str.charAt(index) == '-') {
            positive = false;
            ++index;
        } else if (index < str.length() && str.charAt(index) == '+') {
            ++index;
        }
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            out = out * 10 + str.charAt(index) - '0';
            if (out > Integer.MAX_VALUE) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ++index;
        }
        return positive ? (int) out : (int) -out;
    }

    //我的傻逼解法
//    public int myAtoi(String str) {
//        StringBuffer stringBuffer = new StringBuffer();
//        boolean start = false;
//        short x = 0;
//        for (int i = 0; i < str.length(); i++) {
//            switch (str.charAt(i)) {
//                case '-':
//                    //如果还没开始 并且 str中没有字符
//                    if (!start && stringBuffer.length() == 0) {
//                        stringBuffer.append('-');
//                        start = true;
//                    } else {
//                        if (start && x > 0) {
//                            return Integer.valueOf(stringBuffer.toString());
//                        } else {
//                            return 0;
//                        }
//                    }
//                    break;
//                case '+':
//                    //如果还没开始 并且 str中没有字符
//                    if (!start && stringBuffer.length() == 0) {
//                        stringBuffer.append('+');
//                        start = true;
//                    } else {
//                        if (start && x > 0) {
//                            return Integer.valueOf(stringBuffer.toString());
//                        } else {
//                            return 0;
//                        }
//                    }
//                    break;
//                case ' ':
//                    //如果已经开始，则返回
//                    if (start) {
//                        if (x > 0) {
//                            return Integer.valueOf(stringBuffer.toString());
//                        } else {
//                            return 0;
//                        }
//                    }
//                    break;
//                default:
//                    if (str.charAt(i) > 47 && str.charAt(i) < 58) {
//                        start = true;
//                        stringBuffer.append(str.charAt(i));
//                        if (x == 0 && str.charAt(i) == '0') {
//                            break;
//                        }
//                        ++x;
//                        //如果超过10个数字
//                        if (x > 10) {
//                            if (stringBuffer.charAt(0) == '-') {
//                                return Integer.MIN_VALUE;
//                            } else {
//                                return Integer.MAX_VALUE;
//                            }
//                        }
//                        if (x == 10) {
//                            long temp = Long.parseLong(stringBuffer.toString());
//                            if (temp > Integer.MAX_VALUE) {
//                                return Integer.MAX_VALUE;
//                            } else if (temp < Integer.MIN_VALUE) {
//                                return Integer.MIN_VALUE;
//                            }
//                        }
//                    } else {
//                        if (start && x > 0) {
//                            return Integer.valueOf(stringBuffer.toString());
//                        } else {
//                            return 0;
//                        }
//                    }
//            }
//        }
//        if (start && x > 0) {
//            return Integer.valueOf(stringBuffer.toString());
//        } else {
//            return 0;
//        }
//    }
}
