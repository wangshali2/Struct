package com.atguigu.day04.kmp;

public class KMPAlgorithm {

	public static void main(String[] args) {
		// A：尚
		// B: 硅
		// C: 谷
		// D: 你
		// E: 好
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		//String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
		//String str2 = "尚硅谷你尚硅你~";
		//String str2 = "硅硅谷~";
		
		
        int[] next = KMP.kmpNext(str2);
        int res = KMP.kmpSearch(str1, str2, next);
        System.out.println("子串在源字符串的index=" + res);
        for(int i = 0; i < next.length; i++){
            System.out.println(next[i]);            
        }
//        System.out.println(next.length);
        
	}

}

class KMP {
	
	//str文本串  dest 模式串
	public static int kmpSearch(String str, String dest,int[] next){
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 部分匹配值
     * @param dest
     * @return
     */
	public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){

            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
	
}