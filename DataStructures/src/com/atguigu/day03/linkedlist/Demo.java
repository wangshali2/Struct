package com.atguigu.day03.linkedlist;

/**
 * @Author wsl
 * @Description
 */
public class Demo {
    public static void main(String[] args) {
        String s = "Hello World";

        System.out.println(trans(s, 11));

        String[] str = {"abcg", "abcd", "abcde"};

        System.out.println(longestCommonPrefix(str));
    }

    //反转链表
    public static LinkNode test(LinkNode head) {
        if (head.next == null | head.next.next == null) {
            return null;
        }
        LinkNode cur = head;
        LinkNode pre = null;
        while (cur != null) {
            LinkNode temp = cur.next;
            cur.next = pre;
            pre = cur;

            cur = temp;
        }

        return pre;
    }

    //奇偶位重新排序
    public static LinkNode test2(LinkNode head) {
        if (head == null) {
            return head;
        }
        LinkNode even = head.next;
        LinkNode odd = head;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = even;
        return head;
    }

    //反转字符串
    public static String trans(String s, int n) {
        if (n == 0) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) > 'A' && s.charAt(i) < 'Z') {
                buffer.append((char) (s.charAt(i) + 32));
            } else if (s.charAt(i) > 'a' && s.charAt(i) < 'z') {
                buffer.append((char) (s.charAt(i) - 32));
            } else {
                buffer.append(s.charAt(i));
            }
        }

        buffer.reverse();//hello world    dlrow olleh
        System.out.println(buffer);

        for (int i = 0; i < n; i++) {
            int j = i;

            while (j < n && buffer.charAt(j) != ' ') {
                j++;
            }

            String tmp = buffer.substring(i, j);
            StringBuffer t = new StringBuffer(tmp);
            tmp = t.reverse().toString();
            buffer.replace(i, j, tmp);
            i = j;
        }

        return buffer.toString();

    }

    //最大公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }

        int rows = strs.length;
        int cols = strs[0].length();
        for (int i = 0; i < cols; i++) {
            char firstchar = strs[0].charAt(i);
            for (int j = 0; j < rows; j++) {
                if (strs[j].charAt(i) != firstchar | strs[j].length() == i) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}

class LinkNode {
    int val;
    LinkNode next;

    public LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }
}