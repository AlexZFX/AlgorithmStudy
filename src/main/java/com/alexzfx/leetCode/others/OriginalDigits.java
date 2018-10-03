package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/10/3 9:06
 * Description : 423. 从英文中重建数字
 */
public class OriginalDigits {

    public static void main(String[] args) {
        OriginalDigits originalDigits = new OriginalDigits();
        System.out.println(originalDigits.originalDigits("nnei"));
    }

    public String originalDigits(String s) {
        int[] charNum = new int[26];
        for (char c : s.toCharArray()) {
            ++charNum[c - 97];
        }
        int[] nums = new int[10];
        while (charNum['z' - 97] > 0) {
            ++nums[0];
            --charNum['z' - 97];
            --charNum['e' - 97];
            --charNum['r' - 97];
            --charNum['o' - 97];
        }
        while (charNum['w' - 97] > 0) {
            ++nums[2];
            --charNum['t' - 97];
            --charNum['w' - 97];
            --charNum['o' - 97];
        }
        while (charNum['u' - 97] > 0) {
            ++nums[4];
            --charNum['f' - 97];
            --charNum['o' - 97];
            --charNum['u' - 97];
            --charNum['r' - 97];
        }
        while (charNum['x' - 97] > 0) {
            ++nums[6];
            --charNum['s' - 97];
            --charNum['i' - 97];
            --charNum['x' - 97];
        }
        while (charNum['f' - 97] > 0) {
            ++nums[5];
            --charNum['f' - 97];
            --charNum['i' - 97];
            --charNum['v' - 97];
            --charNum['e' - 97];
        }
        while (charNum['g' - 97] > 0) {
            ++nums[8];
            --charNum['e' - 97];
            --charNum['i' - 97];
            --charNum['g' - 97];
            --charNum['h' - 97];
            --charNum['t' - 97];
        }
        while (charNum['t' - 97] > 0) {
            ++nums[3];
            --charNum['t' - 97];
            --charNum['h' - 97];
            --charNum['r' - 97];
            --charNum['e' - 97];
            --charNum['e' - 97];
        }
        while (charNum['v' - 97] > 0) {
            ++nums[7];
            --charNum['s' - 97];
            --charNum['v' - 97];
            --charNum['n' - 97];
            --charNum['e' - 97];
            --charNum['e' - 97];
        }
        while (charNum['i' - 97] > 0) {
            ++nums[9];
            --charNum['n' - 97];
            --charNum['i' - 97];
            --charNum['n' - 97];
            --charNum['e' - 97];
        }
        nums[1] = charNum['o' - 97];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (nums[i] > 0) {
                sb.append(i);
                --nums[i];
            }
        }
        return sb.toString();
    }

}
