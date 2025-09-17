class Solution {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            min = Math.min(min, sum(tasks[i]));
        }
        return min;
    }

    int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += arr[i];
        }
        return sum;
    }
}