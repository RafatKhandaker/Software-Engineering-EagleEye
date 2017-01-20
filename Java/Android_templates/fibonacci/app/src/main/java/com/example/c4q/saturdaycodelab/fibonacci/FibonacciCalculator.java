package com.example.c4q.saturdaycodelab.fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by C4Q on 11/4/16.
 */

public class FibonacciCalculator {
    Map<Integer, Integer> memo = new HashMap<>();

    public Integer calculateNthFibNumber(int N){
        int value;
        if(memo.containsKey(N)) return memo.get(N);
        if(N <= 0) value = 0;
        else if(N == 1) value = 1;
        else value = calculateNthFibNumber(N - 1) + calculateNthFibNumber(N - 2);
        memo.put(N, value);
        return value;
    }


}
