package utillities;

import java.util.HashMap;
import java.util.Map;

public class ArrayUtils {

    public static boolean areSimilar(int arr1[], int arr2[]) {
        if (arr1 == null || arr2 == null)
            return false;

        if (arr1.length != arr2.length)
            return false;

        
        int count;
        int size = arr1.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            if (countMap.get(arr1[i]) == null)
                countMap.put(arr1[i], 1);
            else {
                count = countMap.get(arr1[i]);
                countMap.put(arr1[i], ++count);
            }
        }

        for (int i = 0; i < size; i++) {
            if (!countMap.containsKey(arr2[i]))
                return false;

            if (countMap.get(arr2[i]) == 0)
                return false;

            count = countMap.get(arr2[i]);
            countMap.put(arr2[i], --count);
        }

        return true;
    }
}
