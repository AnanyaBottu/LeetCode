class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                S.add(asteroids[i]);
            } else {
                int k = asteroids[i];
                while (S.size() > 0 && S.peek() > 0 && Math.abs(k) > S.peek()) {
                    S.pop();
                }
                if (S.size() > 0 && Math.abs(k) == S.peek()) {
                    S.pop();
                } else if (S.size() == 0 || S.peek() < 0) {
                    S.add(k);
                }
            }
        }
        int[] result = new int[S.size()];
        for (int i = 0; i < S.size(); i++)
            result[i] = S.get(i);

        return result;

    }
}