package com.alexzfx.nowCoder.swordToOffer;

/**
 * Author : Alex
 * Date : 2018/3/12 11:31
 * Description :
 */
public class sword1 {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int height = array.length; // 行数
        int width = array[0].length;// 列数
        if (width == 0) {
            return false;
        }
        int x, y;//最终选择的坐标
        //选择最右上角的一个，为一行里最大的，一列里最小的，比较后可以排除一行或一列
        for (int i = 0, j = width - 1; ; ) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                ++i;
                if (i >= height) {
                    return false;
                }
            } else {
                --j;
                if (j < 0) {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        sword1 f = new sword1();
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 2;
        System.out.println(f.find(target, array));
    }

}
