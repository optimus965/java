package Jvastr;
class string4 {
    public void brute(String str, String pattern) {
        check(str.toCharArray(),pattern.toCharArray());
    }
    public void check(char[] text, char[] pattern) {
        final int n= text.length;
        final int  m = pattern.length;
        for(int i = 0 ; i <= (n - m);i++) {
            int count = 0;
            for(int j = 0; j < m; j++) {
                if(pattern[j] == text[i+j]) {
                    count = count + 1;
                }
                if(count == m) {
                    System.out.println(i);
                }
            }
        }
    }
}
class work {
    public static void main(String[] args) {
        string4 str = new string4();
        str.brute("aaaaaaaaaaaabc","bc");

    }

}
