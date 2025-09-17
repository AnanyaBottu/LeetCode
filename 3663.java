class Solution {
    public int getLeastFrequentDigit(int n) {
        int arr[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        while (n > 0) {
            int digit = n % 10;
            arr[digit] += 1;
            n = n / 10;
        }
        int minFreq = Integer.MAX_VALUE;
        int ret = -1;
        for (int i = 0; i < 10; i++) {
            if (arr[i] > 0 && arr[i] < minFreq) {
                minFreq = arr[i];
                ret = i;
            }
        }
        return ret;
    }
}