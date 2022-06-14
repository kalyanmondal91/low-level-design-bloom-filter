package com.github.systemdesign;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final BloomFilter bloomFilter;

    public AppRunner(BloomFilter bloomFilter) {
        this.bloomFilter = bloomFilter;
    }

    @Override
    public void run(String... args) throws Exception {
        String[] strArray = new String[] {"abound","abounds","abundance","abundant","accessible","bloom",
                "blossom","bolster","bonny","bonus","bonuses","coherent","cohesive","colorful","comely",
                "comfort","gems","generosity","generous","generously","genial","bluff","cheater","hate",
                "war","humanity","racism","hurt","nuke","gloomy","facebook","geeksforgeeks","twitter",
                "colorful", "hurt", "geeks", "bloom", "flower"};
        for(String str : strArray)
            bloomFilter.insert(str);

    }
}
