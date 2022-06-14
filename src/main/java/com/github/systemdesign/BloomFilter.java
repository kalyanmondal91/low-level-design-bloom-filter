package com.github.systemdesign;

import org.springframework.stereotype.Component;

@Component
public class BloomFilter {

    static int MAX_ARR_SIZE = 10000;
    static boolean bitArray[] = new boolean[MAX_ARR_SIZE];

    boolean lookup(String str) {
        int a = hash1(str);
        int b = hash2(str);
        int c = hash3(str);
        int d = hash4(str);

        if(bitArray[a] && bitArray[a] && bitArray[a] && bitArray[d])
            return true;
        return false;
    }

    void insert(String str) {
        if(lookup(str)) {
            System.out.println("String " + str + " might be present");
        } else {
            int a = hash1(str);
            int b = hash2(str);
            int c = hash3(str);
            int d = hash4(str);
            bitArray[a] = true;
            bitArray[b] = true;
            bitArray[c] = true;
            bitArray[d] = true;
            System.out.println("String " + str + " inserted");
        }
    }

    private int hash1(String str) {
        long hash = 0;
        for(Character ch : str.toCharArray()) {
            hash += (int) ch;
            hash %= MAX_ARR_SIZE;
        }
        return (int) hash;
    }

    private int hash2(String str) {
        long hash = 1, i = 0;
        for(Character ch : str.toCharArray()) {
            hash += Math.pow(19, i++) * (int) ch;
            hash %= MAX_ARR_SIZE;
        }
        return (int) (hash % MAX_ARR_SIZE);
    }

    private int hash3(String str) {
        long hash = 7;
        for(Character ch : str.toCharArray()) {
            hash = (hash * 31 + (int)ch) % MAX_ARR_SIZE;
        }
        return (int) (hash % MAX_ARR_SIZE);
    }

    private int hash4(String str) {
        long hash = 3, i = 0;
        for(Character ch : str.toCharArray()) {
            hash += hash * 7 + (int) ch * Math.pow(7, i++);
            hash %= MAX_ARR_SIZE;
        }
        return (int) hash ;
    }
}
