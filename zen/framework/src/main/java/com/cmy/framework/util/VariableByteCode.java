package com.cmy.framework.util;

/**
 * 可变字节码压缩整十数算法
 * Created by mengyingc on 2017/3/29.
 */
public class VariableByteCode {
    private static final int mask = 128;

    public StringBuffer encodeNumber(int n) {
        StringBuffer bytes = new StringBuffer();
        while (true) {
            if (n / mask == 0) {

                    int len = Integer.toBinaryString(n).length();
                    while (len < 8) {
                        bytes.append("0");
                        len++;
                    }

                break;
            } else {
                bytes.append(encodeNumber(n / mask));
                n = n % mask;
            }
        }
        bytes.append(Integer.toBinaryString(n));
        return bytes;
    }

    public StringBuffer getVariableByteCode(int n) {
        StringBuffer bytes = encodeNumber(130 );
        //将byte的最后一个字节的第一位设置成1，表示结束位标记
        bytes.setCharAt(bytes.length() - 8, '1');
        return bytes;
    }

    public int diffEncode(int n, int pre) {
        int diff = pre - n;
        return diff;
    }

    public static void main(String[] args) {
        VariableByteCode variableByteCode = new VariableByteCode();
        StringBuffer bytes = variableByteCode.getVariableByteCode(130);
        System.out.printf("" + bytes.toString());
    }
}
