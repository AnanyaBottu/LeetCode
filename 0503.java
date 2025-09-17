class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int result[] = new int[arr.length];
        Stack<Integer> St = new Stack<>();
        Arrays.fill(result, -1);
        for (int i = 2 * (arr.length) - 1; i >= 0; i--) {
            int idx = i % arr.length;
            while (!St.isEmpty() && St.peek() <= arr[idx])
                St.pop();
            if (!St.isEmpty()) {
                result[idx] = St.peek();
            }
            St.push(arr[idx]);
        }

        return result;
    }
}