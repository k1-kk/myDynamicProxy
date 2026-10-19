package com.example.mydynamicproxy1;

public class Test {
    static void main(String[] args) {

        Star kunKun = ProxyUtil.createProxy(new BigStar("坤坤"));
        String result = kunKun.sing("基你太美");
        System.out.println(result);
        kunKun.dance();
    }
}
