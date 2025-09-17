import java.util.*;

class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> S = new Stack<>();

        for (int i = 0; i < nums.length(); i++) {
            while (!S.isEmpty() && k > 0 && nums.charAt(i) < S.peek()) {
                S.pop();
                k--;
            }
            S.push(nums.charAt(i));
        }

        while (k > 0 && !S.isEmpty()) {
            S.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S) {
            sb.append(c);
        }

        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        return (idx == sb.length()) ? "0" : sb.substring(idx);
    }
}
