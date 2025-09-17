class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        Stack<Integer> S = new Stack<>();
        int n = nums.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        int[] nle = new int[n];
        int[] ple = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!S.isEmpty() && nums[S.peek()] >= nums[i]) {
                S.pop();
            }
            nse[i] = S.isEmpty() ? n : S.peek();
            S.push(i);
        }
        S.clear();
        for (int i = 0; i < n; i++) {
            while (!S.isEmpty() && nums[S.peek()] > nums[i]) {
                S.pop();
            }
            pse[i] = S.isEmpty() ? -1 : S.peek();
            S.push(i);
        }
        S.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!S.isEmpty() && nums[S.peek()] <= nums[i]) {
                S.pop();
            }
            nle[i] = S.isEmpty() ? n : S.peek();
            S.push(i);
        }
        S.clear();
        for (int i = 0; i < n; i++) {
            while (!S.isEmpty() && nums[S.peek()] < nums[i]) {
                S.pop();
            }
            ple[i] = S.isEmpty() ? -1 : S.peek();
            S.push(i);
        }
        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * (i - ple[i]) * (nle[i] - i);
            sum -= (long) nums[i] * (i - pse[i]) * (nse[i] - i);
        }

        return sum;
    }
}