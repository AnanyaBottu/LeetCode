class Solution {
    public String[] divideString(String s, int k, char fill) {
        int l = 0;
        if (s.length() % k == 0) {
            l = s.length() / k;
        } else {
            l = ((int) s.length() / k) + 1;
        }
        System.out.println(l);
        String out[] = new String[l];
        for (int i = 0; i < l; i++) {
            String str = "";
            for (int j = k * i; j < k * i + k; j++) {
                if (j > (s.length() - 1)) {
                    str += fill;
                } else {
                    str += s.charAt(j);
                }
            }
            out[i] = str;
        }
        return out;
    }
}