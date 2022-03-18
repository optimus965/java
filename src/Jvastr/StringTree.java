package Jvastr;
import java.util.HashMap;
import java.util.Map;
/*package whatever //do not write package name here */
import java.io.*;
import java.util.*;
class str {
    int count = 0;
    ArrayList<ArrayList<Character>> subset = new ArrayList<>();
    public  void subset1(ArrayList<Character> output, char[] original,int index) {
        if(index == original.length) {
            subset.add(output);
            return;
        }
        count = count + 1;
        subset1(new ArrayList<>(output),original,index + 1);
        output.add(original[index]);
        subset1(new ArrayList<>(output),original,index + 1);
    }
    public void return1(ArrayList<Character> output, char[] original,int index) {
        subset1(output,original,index);
        for(List s : subset) {
            System.out.println(s);
        }
        System.out.println(count);

    }
}
class StringTree {
    public static void main(String[] args) {
        str new1 = new str();
        ArrayList<Character> output = new ArrayList<>();
        String str = "";
        char[] char1 = str.toCharArray();
        new1.return1(output,char1,0);

    }
}