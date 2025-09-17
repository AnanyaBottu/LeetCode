class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int MOD = 1_000_000_007;
        Stack<Integer> S = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n], nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!S.isEmpty() && arr[S.peek()] >= arr[i]) {
                S.pop();
            }
            nse[i] = S.isEmpty() ? n : S.peek();
            S.push(i);
        }
        S.clear();
        for (int i = 0; i < n; i++) {
            while (!S.isEmpty() && arr[S.peek()] > arr[i]) {
                S.pop();
            }
            pse[i] = S.isEmpty() ? -1 : S.peek();
            S.push(i);
        }
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            long contrib = (arr[i] * left % MOD) * right % MOD;
            sum = (sum + contrib) % MOD;
        }
        return (int) sum;

    }
}