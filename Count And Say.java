public class Solution {
    public String countAndSay(int n) {
        String res = "";
        if (n <= 0) {
            return res;// edge case
        }
        res = "1";// Initialize the res string as base case
        for (int i = 2; i <= n; i++) {//starting loop from 2 to n, generate the nth result.
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int j = 1;//j starting with 1
            for (; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {//if the current number is the same with the previouse number we increase the counter
                    count++;
                } else {//different number, we output the previous number and reset the counter
                    sb.append(count);
                    sb.append(res.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count);//output the last number
            sb.append(res.charAt(res.length() - 1));
            res = sb.toString();
        }
        return res;
    }
}