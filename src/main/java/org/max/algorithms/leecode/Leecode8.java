package org.max.algorithms.leecode;

/**
 * @description:converts a string to an integer.
 */
public class Leecode8 {

    public static void main(String[] args) {
        String str = " -42";
        int result = myAtoi(str);
        System.out.println(result);
    }

    public static int myAtoi(String str) {
    	int result = 0;
    	if(null == str || str.length() == 0) {
    		return 0;
    	}
    	result = convert(str);
    	return result;
    }

	private static int convert(String str) {
		//TODO
		for(int i = 0; i < str.length(); i++) {
			
		}
		return 0;
	}

}
