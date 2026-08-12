package dsa.blind75Question.heap;

/*
LC 347
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any
order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

 */

import java.util.*;

public class KFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }


        /*

        // using Bucket Sort
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int idx = 0;

        for (int pos = bucket.length - 1; pos >= 0 && idx < k; pos--) {
            if (bucket[pos] == null) continue;
            for (int num : bucket[pos]) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }
        return result;

         */


        // Using Min Heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll()[0];
        }
        return result;

    }

}
