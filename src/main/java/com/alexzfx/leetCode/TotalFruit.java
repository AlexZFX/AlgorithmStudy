package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/9/16 9:34
 * Description : 904. 水果成篮
 * <p>
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 * <p>
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 * <p>
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * 用这个程序你能收集的水果总量是多少？
 */
public class TotalFruit {

    public static void main(String[] args) {
        int[] tree = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        TotalFruit totalFruit = new TotalFruit();
        System.out.println(totalFruit.totalFruit(tree));
    }

    public int totalFruit(int[] tree) {
        int len = tree.length;
        if (len == 1 || len == 2) {
            return len;
        }
        int one = tree[0], res = 1, count = res, two;
        int off;
        for (int i = 1; i < len; i++) {
            off = i;
            two = tree[i];
            ++count;
            ++off;
            while (off < len && one == two) {
                two = tree[off];
                ++off;
                ++count;
            }
            while (off < len && (tree[off] == one || tree[off] == two)) {
                ++count;
                ++off;
            }
            res = Math.max(res, count);
            if (len - i <= res) {
                break;
            }
            one = tree[i];
            count = 1;
        }
        return res;
    }
}
