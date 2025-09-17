class Solution {
    public int smallestAbsent(int[] nums) {
        int sums = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        for (int i = 0; i < nums.length; i++) {
            sums += nums[i];
        }
        int avg = sums / nums.length;
        int candidate = avg + 1;
        while (set.contains(candidate) || candidate <= avg || candidate <= 0)
            candidate++;
        return candidate;

    }
}