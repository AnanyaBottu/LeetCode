class Solution {
    public int findLucky(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count += 1;
                }
            }
            if (count == arr[i]) {
                arr2[i] = count;
            }
        }
        int max = arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
            }
        }
        if (max != 0) {
            return max;
        } else {
            return -1;
        }
    }
}