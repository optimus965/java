package Jvastr;

import org.w3c.dom.Text;

class string1 {
    int bruteForcesearch(String text, String pattern) {
        return bruteForcesearch(text.toCharArray(), pattern.toCharArray());
    }

    int bruteForcesearch(char[] text, char[] pattern) {
        int i = 0;
        int j = 0;
        final int n = text.length;
        final int m = pattern.length;
        while (i <= (n - m)) {
            j = 0;
            while (j <= (m - 1) && pattern[j] == text[i + j]) {
                j++;
            }
            if (j == m) return i;
            i++;

        }
        return -1;
    }

    int robinKarp(String text, String pattern) {
        return robinKarp(text.toCharArray(), pattern.toCharArray());
    }

    int robinKarp(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        int i, j;
        int prime = 101;
        int powm = 1;
        int TextHash = 0, PatternHash = 0;
        if (m == 0 || m > n) {
            return -1;
        }
        for (i = 0; i < m - 1; i++) {
            powm = (powm << 1) % prime;

        }
        int pattern1 = 0;
        System.out.println(powm);
        for (i = 0; i < m; i++) {
            PatternHash = ((PatternHash << 1) + pattern[i]) % prime;
            TextHash = ((TextHash << 1) + text[i]) % prime;
        }
        for(int k = 0; k <= (n -m);k++ ) {
            for(int k1 = 0; k1 < m; k1++) {
                pattern1 = ((pattern1 << 1) + text[k + k1])%prime;
            }

            pattern1 = 0;

        }
        for (i = 0; i <= (n - m); i++) {
            if (TextHash == PatternHash) {
                for (j = 0; j < m; j++) {
                    if (text[i + j] != pattern[j]) {
                        break;
                    }
                }
                if (j == m)
                    return i;
            }

            TextHash = (((TextHash - text[i] * powm) << 1) + text[i + m]) %
                    prime;

            if (TextHash < 0) {
                TextHash = (TextHash + prime);

            }
        }
        return -1;
    }

}
public class string {
    public static void main(String[] args) {
        string1 str = new string1();
        System.out.println(str.robinKarp("abbcoisfoishg","fois"));
    }
}
