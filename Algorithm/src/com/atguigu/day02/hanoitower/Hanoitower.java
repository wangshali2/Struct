package com.atguigu.day02.hanoitower;

/**
 * ��ŵ������A�����ϵ����������Ƶ�C������
 * �����㷨
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }


	/**
	 *
	 * @param num
	 * @param a ��һ������
	 * @param b �м����������
	 * @param c Ŀ������
	 */
    public static void hanoiTower(int num, char a, char b, char c) {
        //���ֻ��һ������
        if (num == 1) {
            System.out.println("��1���̴� " + a + "->" + c);
        } else {
            //��������� n >= 2 ������������ǿ��Կ����������� 1.���±ߵ�һ���� 2. �����������
            //1. �Ȱ� A������������̶��Ƶ�B A->B�� �ƶ����̻�ʹ�õ� c
            hanoiTower(num - 1, a, c, b);
            //2. �����±ߵ��� A->C
            System.out.println("��" + num + "���̴� " + a + "->" + c);
            //3. ��B���������� �� B->C , �ƶ�����ʹ�õ� a��
            hanoiTower(num - 1, b, a, c);

        }
    }

}
