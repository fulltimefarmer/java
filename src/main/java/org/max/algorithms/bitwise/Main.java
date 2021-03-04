package org.max.algorithms.bitwise;

public class Main {

    // &	与	两个位都为1时，结果才为1
    // |	或	两个位都为0时，结果才为0
    // ^	异或	两个位相同为0，相异为1 (不进位相加)
    // ~	取反	0变1，1变0
    // <<	左移	各二进位全部左移若干位，高位丢弃，低位补0
    // >>	右移	各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移）
    public static void main(String[] args) {
        // 2n+1
    	Integer num1 = 7;
    	System.out.println(Integer.toBinaryString(num1));
        System.out.println((num1<<1|1));
        System.out.println();
        
        //提取最右侧的1
        Integer eight = 8;
        System.out.println(Integer.toBinaryString(eight));
        System.out.println((eight&(~eight)+1));
        System.out.println();
        
        //提取所有的1
        Integer num2 = 139;
        System.out.println(Integer.toBinaryString(num2));
        int count = 0;
        while(num2!=0) {
        	int rightOne = (num2&(~num2)+1);
        	count++;
        	num2 ^= rightOne;
        }
        System.out.println(count);
        
        //两数字交换
        Integer num3 = 123;
        Integer num4 = 321;
        System.out.println(num3);
        System.out.println(num4);
        num3 = num3 ^ num4;
        num4 = num3 ^ num4;
		num3 = num3 ^ num4;
		System.out.println(num3);
        System.out.println(num4);
    }

}
