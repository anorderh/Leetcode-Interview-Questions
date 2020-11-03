/**
 *  NAME: Anthony Norderhaug
 *  DATE: 11/3/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 *  
*/
class SolutionS {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        if (needleLength == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.length() - i >= needleLength) {
                if (haystack.substring(i, i+needleLength).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;

    }
}