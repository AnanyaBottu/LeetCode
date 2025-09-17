class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums)
            set.add(i);
        ArrayList<Integer> al = new ArrayList<>(set);
        Collections.sort(al, Collections.reverseOrder());

        int size = Math.min(k, al.size());
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = al.get(i);
        }
        return ans;
    }
}