import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            int original = prices[i];
            prices[i] = !stack.isEmpty() ? prices[i] - stack.peek() : prices[i];
            stack.push(original);
        }
        return prices;
    }
}
