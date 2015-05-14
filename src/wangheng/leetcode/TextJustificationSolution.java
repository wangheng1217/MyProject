package wangheng.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationSolution {
    public List<String> fullJustify2(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        int start = 0;
        int l = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (l == 0) l = word.length();
            else l = l + word.length() + 1;
            
            if (l <= L) {
                if (i == words.length-1) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = start; k <= i; k++) {
                        sb.append(words[k]);
                        if (k < i) sb.append(" ");
                    }
                    for (int k = 0; k < L-l; k++) {
                        sb.append(" ");
                    }
                    result.add(sb.toString());
                }
            } else {
                if (i-start == 1) {
                    StringBuilder sb = new StringBuilder(words[start]);
                    for (int k = 0; k < L-words[start].length(); k++) {
                        sb.append(" ");
                    }
                    result.add(sb.toString());
                } else {
                    l = l - word.length() - 1;
                    int extraSpace = L - l;
                    int avg = extraSpace/(i-start-1) + 1;
                    int extra = extraSpace%(i-start-1);
                    StringBuilder avgSpaceSb = new StringBuilder();
                    for (int k = 0; k < avg; k++) {
                        avgSpaceSb.append(" ");
                    }
                    String avgSpace = avgSpaceSb.toString();
                    
                    StringBuilder sb = new StringBuilder();
                    for (int k = start; k < i; k++) {
                        sb.append(words[k]);
                        if (k < i-1) {
                            sb.append(avgSpace);
                            if (k - start < extra) {
                                sb.append(" ");
                            }
                        }
                    }
                    
                    result.add(sb.toString());
                }
                
                start = i;
                l = 0;
                i--;
            }
        }
        
        return result;
    }

    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        fullJustify(words, 0, L, res);
        return res;
    }

    private void fullJustify(String[] words, int start, int L,
            ArrayList<String> res) {
        int length = 0;
        int end = -1;
        for (int i = start; i < words.length; i++) {
            length = length + words[i].length();
            if (length > L) {
                end = i - 1;
                length = length - words[i].length() - 1;
                break;
            }
            if (i < words.length - 1)
                length = length + 1;
        }

        if (end == -1) {
            String s = "";
            for (int i = start; i < words.length; i++) {
                s = s + words[i];
                if (i < words.length - 1)
                    s = s + " ";
            }
            int sLength = s.length();
            for (int i = 0; i < L - sLength; i++) {
                s = s + " ";
            }
            res.add(s);
        } else {
            int n = end - start + 1;
            int extraSpaces = L - length;
            String s = "";

            // consider the corner case that have only one word in a line
            if (n == 1) {
                s = s + words[start];
                for (int i = 0; i < L - words[start].length(); i++) {
                    s = s + " ";
                }
            } else {
                int aveExtraSpaces = extraSpaces / (n - 1);
                int frontExtraSpaces = extraSpaces % (n - 1);

                for (int i = 0; i < n; i++) {
                    s = s + words[start + i];
                    if (i != n - 1) {
                        for (int j = 0; j < aveExtraSpaces + 1; j++) {
                            s = s + " ";
                        }
                        if (i < frontExtraSpaces) {
                            s = s + " ";
                        }
                    }
                }
            }

            res.add(s);

            fullJustify(words, end + 1, L, res);
        }
    }
}
