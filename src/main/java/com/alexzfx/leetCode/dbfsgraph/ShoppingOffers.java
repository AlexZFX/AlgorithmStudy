package com.alexzfx.leetCode.dbfsgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/22 11:12
 * Description : 638. 大礼包
 * <p>
 * 在LeetCode商店中， 有许多在售的物品。
 * <p>
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * <p>
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * <p>
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 * <p>
 * 任意大礼包可无限次购买。
 * <p>
 * 最多6种物品， 100种大礼包。
 * 每种物品，你最多只需要购买6个。
 * 你不可以购买超出待购清单的物品，即使更便宜。
 */
public class ShoppingOffers {

    public static void main(String[] args) {
        ShoppingOffers shoppingOffers = new ShoppingOffers();
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
        price.add(4);
        List<List<Integer>> specials = new ArrayList<>();
        List<Integer> sp1 = new ArrayList<>();
        sp1.add(1);
        sp1.add(1);
        sp1.add(0);
        sp1.add(4);
        List<Integer> sp2 = new ArrayList<>();
        sp2.add(2);
        sp2.add(2);
        sp2.add(1);
        sp2.add(9);
        specials.add(sp1);
        specials.add(sp2);
        List<Integer> needs = new ArrayList<>();
        needs.add(1);
        needs.add(2);
        needs.add(1);
        System.out.println(shoppingOffers.shoppingOffers(price, specials, needs));
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int specialIndex) {
        int sum = Integer.MAX_VALUE;
        int min = 0;
        for (int i = 0; i < needs.size(); i++) {
            min += needs.get(i) * price.get(i);
        }
        for (int i = specialIndex; i < special.size(); i++) {
            List<Integer> tempOffer = special.get(i);
            if (canBuy(tempOffer, needs)) {
                for (int j = 0; j < needs.size(); j++) {
                    needs.set(j, needs.get(j) - tempOffer.get(j));
                }
                min = Math.min(min, tempOffer.get(tempOffer.size() - 1) + dfs(price, special, needs, i));
                for (int j = 0; j < needs.size(); j++) {
                    needs.set(j, needs.get(j) + tempOffer.get(j));
                }
            } else {
                sum = 0;
                for (int j = 0; j < needs.size(); j++) {
                    sum += needs.get(j) * price.get(j);
                }
            }
        }
        return Math.min(sum, min);
    }

    private boolean canBuy(List<Integer> offer, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (!(needs.get(i) >= offer.get(i))) {
                return false;
            }
        }
        return true;
    }
}
