package com.markwatson.search;

import com.markwatson.search.BingSpelling;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Unit test for NLP.
 */
public class SpellingTest extends TestCase {

  public SpellingTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(SpellingTest.class);
  }


  public void testSpelling() throws Exception {
    assertTrue(true);
    String query = "the parot talks a lot";
    String json = BingSpelling.spelling(query);
    System.out.println(json);
  }

}


