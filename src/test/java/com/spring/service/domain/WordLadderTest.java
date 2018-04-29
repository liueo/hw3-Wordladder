package com.spring.service.domain;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class WordLadderTest {

    @Test
    public void testfindLadder() {
        WordLadder wl = new WordLadder();
        String word1 = "azure";
        String word2 = "metal";
        Stack s = wl.findLadder(word1,word2);
        assertTrue(s.isEmpty());
    }

}