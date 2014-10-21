//key idea reverse an integer.
//time complexity O(n)
//note: be careful to use long to store the reverse of number x, it might be too big for an integer variable.
//note2: if x < 0 it cannot be a palindrome.
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long reverse = 0;
        long temp = (long) x;
        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return (long) x == reverse;
    }
}