package com.spring.service.domain;

import java.util.*;
import java.lang.*;
import java.io.*;

public class WordLadder {
    //words is used to store all words in the input dictionary file.
    //track is used to store all words that has been in the stack of ladder before.
    public static Set<String> words = new HashSet<String>();
    public static Set<String> track = new HashSet<String>();

    public static Stack<String> findLadder(String word1, String word2) {
        try {
            Scanner scan = new Scanner(System.in);
            String fileName = "C://dictionary.txt";
            File inFile = new File(fileName);

            BufferedReader br = new BufferedReader(new FileReader(inFile));
            String wordstr = new String();
            while ((wordstr = br.readLine()) != null)
                words.add(wordstr);
            br.close();
            //wordQueue is to store all the stack of partial ladder.
            //wordStack is to store partial ladder.
            Queue<Stack<String>> wordQueue = new LinkedList<Stack<String>>();
            track.add(word1);
            Stack<String> wordStack = new Stack<String>();
            wordStack.push(word1);
            wordQueue.add(wordStack);
            //wordS is the top stack of the wordQueue.
            Stack<String> wordS = new Stack<String>();
            while (!wordQueue.isEmpty()) {
                wordS = wordQueue.poll();
                //word is the top word of the wordS.
                String word = wordS.peek();
                for (int i = 0; i < word.length(); i++) {
                    char original_ch = word.charAt(i);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != original_ch) {
                            char[] char_array = word.toCharArray();
                            char_array[i] = ch;
                            String changable_word = new String(char_array);
                            if (changable_word.contentEquals(word2)) {
                                wordS.push(changable_word);
                                return wordS;
                            }
                            if (words.contains(changable_word) && (!track.contains(changable_word))) {
                                track.add(changable_word);
                                Stack<String> word_stack = new Stack<String>();
                                word_stack.addAll(wordS);
                                word_stack.push(changable_word);
                                wordQueue.add(word_stack);
                            }
                        }
                    }

                }
            }
            Stack<String> empty = new Stack<String>();
            String ladderNotFound = "No word ladder found from "+word2+" back to "+word1+".";
            empty.push(ladderNotFound);
            return empty;
        }
        catch (IOException e) {
            return new Stack<String>();
        }
    }
}



