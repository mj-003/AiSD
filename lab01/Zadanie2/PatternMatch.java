package Zadanie2;// Java Program to implement Bitap Algorithm.

import java.util.Arrays;

public class PatternMatch {
    public PatternMatch() {
    }

    public int bitap_search(String t, String p) {
        char[] text = t.toCharArray();
        char[] pattern = p.toCharArray();
        int len = pattern.length;
        long[] pattern_mask = new long[256];    // liczba znakow w kodzie ASCII
        long R = ~1;    // wektor bitowy (do porownania wzorca z tekstem)

        if (len == 0 || len > 63) {
            return -1;
        }

        for (int i = 0; i < 256; ++i) {
            pattern_mask[i] = ~0;
        }
        for (int i = 0; i < len; i++) {
            pattern_mask[pattern[i]] &= ~(1L << i); // ustawienie maski bitowej dla znaku
        }

        for (int i = 0; i < text.length; i++) {
            R |= pattern_mask[text[i]];     // OR
            R <<= 1;                        // Shift

            if ((R & (1L << len)) == 0)
                return i - len + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        String pattern = "abc";
        String text = "adcaaaabdabcab";
        PatternMatch patternMatch = new PatternMatch();
        System.out.println(patternMatch.bitap_search(text, pattern));

    }
}

