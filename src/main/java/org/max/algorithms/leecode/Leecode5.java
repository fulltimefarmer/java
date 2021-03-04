package org.max.algorithms.leecode;

/**
 * @description: Longest Substring Without Repeating Characters
 */
public class Leecode5 {

    public static void main(String[] args) {
        String str = "abcde";
        String maxMirrorStr = findMirrorStr(str);
        System.out.println(maxMirrorStr);
    }

    static String findMirrorStr(String str){
        if(null == str || str.length() == 0){
            return str;
        }
        String result = str.substring(0, 1);
        int maxlen = 1;
        for(int i = 0;i < str.length(); i++){
            String odd = maxString(str, i, i);
            String even = maxString(str, i, i+1);
            String maxString = odd.length() > even.length() ? odd : even;
            if(maxString.length() > maxlen){
                maxlen = maxString.length();
                result = maxString;
            }
        }
        return result;
    }

    static String maxString(String str, int left, int right){
        int length = str.length();
        int i = left;
        int j = right;
        while(i >= 0 && j < length){
            if(str.charAt(i) == str.charAt(j)){
                i -= 1;
                j += 1;
            } else {
                break;
            }
        }
        String max = str.substring(i+1, j);
        return max;
    }

}
