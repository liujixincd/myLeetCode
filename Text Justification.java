/*
时间复杂度 O(n) 每个单词访问不超过两次
结果大小 O(L * K) k 是结果 行数
*/
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if (words.length == 0) {
            return res;
        }
        int start = 0;
        int curLen = 0;
        for (int i = 0; i <= words.length; i++) {
            if (i == words.length || curLen + words[i].length() + i - start > L) {
                int space = L - curLen;
                int spaceSlot = i - 1 - start;
                StringBuilder sb = new StringBuilder();
                if (i == words.length || spaceSlot == 0) {
                    for (int j = start; j < i; j++) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            addSpace(sb, 1);
                        }
                    }
                    addSpace(sb, L - sb.length());
                } else {
                    int spacePerSlot = space / spaceSlot;
                    int extraSpace = space % spaceSlot;
                    for (int j = start; j < i; j++) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            addSpace(sb, spacePerSlot + (extraSpace - (j - start) > 0 ? 1 : 0));
                        }
                    }
                    
                }
                res.add(sb.toString());
                curLen = 0;
                start = i;
            }
            if (i < words.length) {
                curLen += words[i].length();
            }
        }
        return res;
    }
    public void addSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
    }
}