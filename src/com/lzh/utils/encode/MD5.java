package com.lzh.utils.encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	/**
     * MD5加密算法
     * @param str   需要转化为MD5码的字符串
     * @return  返回一个32位16进制的字符串
     */
    public static String toMd5(String str) {
        StringBuffer md5Code = null;
        try {
        //获取加密方式为md5的算法对象
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] digest = instance.digest(str.getBytes());
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 0xff);
                if (hexString.length() < 2) {
                    hexString = "0"+hexString;
                }
                md5Code = md5Code.append(b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Code.toString();

    }
    /**
     * 思路过程：
     * 1、str.getBytes()：将字符串转化为字节数组。字符串中每个字符转换为对应的ASCII值作为字节数组中的一个元素
     * 2、将字节数组通过固定算法转换为16个元素的有符号哈希值字节数组
     * 3、将哈希字节数组的每个元素通过0xff与运算转换为两位无符号16进制的字符串
     * 4、将不足两位的无符号16进制的字符串前面加0
     * 5、通过StringBuffer.append()函数将16个长度为2的无符号进制字符串合并为一个32位String类型的MD5码
     */
}
