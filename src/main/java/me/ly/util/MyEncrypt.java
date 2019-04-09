package me.ly.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MyEncrypt {

    public static String encrypt(String password,String salt){
        Md5Hash md5Hash = new Md5Hash(password,salt,3);
        return md5Hash.toString();
    }


    //3fed7a346e430ea4c2aa10250928f4de
    public static void main(String[] args) {
        System.out.println(encrypt("admin","admin"));
    }
}
