class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            s = newString(s);
        }
        return s.charAt(0) == s.charAt(1);
    }

    public String newString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            int a = Integer.parseInt(String.valueOf(s.charAt(i)));
            int b = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
            int c = (a + b) % 10;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}