package org.max.algorithms.leecode;

import java.util.*;

/**
 * @description:Given a string s, find the length of the longest substring without repeating characters.
 */
public class Leecode3 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int result = lengthOfLongestSubstring(str);
        System.out.println(result);
    }

    static int lengthOfLongestSubstring(String s){
        if(null == s || s.length() == 0){
            return 0;
        }
        int result = 1;
        for(int i=0;i<s.length();i++){
            int maxLen = getMaxNonDupLen(s, i);
            if(maxLen > result){
                result = maxLen;
            }
        }
        return result;
    }

    static int getMaxNonDupLen(String str, int index){
        int length = str.length();
        List<Character> temp = new ArrayList<>();
        for(int i=index; i<length;i++){
            if(temp.contains(str.charAt(i))){
                break;
            }
            temp.add(str.charAt(i));
        }
        return temp.size();
    }

}
