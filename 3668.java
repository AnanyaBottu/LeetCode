class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int result[] = new int[friends.length];
        int indx = 0;
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (order[i] == friends[j]) {
                    result[indx] = order[i];
                    indx++;
                }

            }
        }
        return result;
    }
}