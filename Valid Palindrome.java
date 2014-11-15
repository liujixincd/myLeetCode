public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!(Character.isLetter(s.charAt(left)) || Character.isDigit(s.charAt(left))) && left < right) {
                left++;
            }
            while (!(Character.isLetter(s.charAt(right)) || Character.isDigit(s.charAt(right))) && left < right) {
                right --;
            }
            if (!isValid(s.charAt(left), s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    public boolean isValid(char c1, char c2) {
        if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
            return true;
        }
        return false;
    }
}