package wangheng.leetcode;

public class CompareVersionNumbersSolution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < ver1.length || j < ver2.length) {
            int verNum1 = i < ver1.length ? Integer.valueOf(ver1[i]) : 0;
            int verNum2 = j < ver2.length ? Integer.valueOf(ver2[j]) : 0;
            if (verNum1 < verNum2) {
                return -1;
            } else if (verNum1 > verNum2) {
                return 1;
            } else {
                i++;
                j++;
            }
        }
        
        return 0;
    }

}
