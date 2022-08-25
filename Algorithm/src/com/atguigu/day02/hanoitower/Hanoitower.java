package com.atguigu.day02.hanoitower;

/**
 * 汉诺塔：将A柱子上的所有盘子移到C柱子上
 * 分治算法
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }


	/**
	 *
	 * @param num
	 * @param a 第一个柱子
	 * @param b 中间过到的柱子
	 * @param c 目标柱子
	 */
    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘子
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 A最上面的所有盘都移到B A->B， 移动过程会使用到 c
            hanoiTower(num - 1, a, c, b);
            //2. 把最下边的盘 A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔
            hanoiTower(num - 1, b, a, c);

        }
    }

}
