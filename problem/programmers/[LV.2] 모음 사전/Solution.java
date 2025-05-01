package org.example;

public class Solution {

    private char[] chars = {'A', 'E', "I", "O", "U"};

    private StringBuffer tempWord;
    private int count = 0;

    public int solution(String word) {
        String startWord = "";
        tempWord = new StringBuffer(startWord);
        while(!word.equals(tempWord.toString())) {
             count += 1;
            if (tempWord.length() != 5) tempWord.append("A");
            else change(4);
        }
        return count;
    }

    public void change(int index) {
        if (tempWord.charAt(index) == 'U') {
            ca(index-1);
            tempWord.deleteCharAt(tempWord.length()-1);
        } else tempWord.setCharAt(index, up(tempWord.charAt(index)));
    }

    public char up(char a) {
        if (a == 'A') return 'E';
        if (a == 'E') return 'I';
        if (a == 'I') return 'O';
        return 'U';
    }

}