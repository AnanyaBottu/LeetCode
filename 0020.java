class Solution {
    public boolean isValid(String s) {
        Stack<Character> St = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                St.add(s.charAt(i));
            } else {
                if (St.isEmpty()) {
                    return false;
                }
                char top = St.peek();
                if (s.charAt(i) == ')' && top == '('
                        || s.charAt(i) == '}' && top == '{'
                        || s.charAt(i) == ']' && top == '[') {
                    St.pop();
                } else {
                    return false;
                }

            }
        }
        return St.size() == 0;
    }
}