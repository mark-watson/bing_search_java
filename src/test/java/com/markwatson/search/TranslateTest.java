package com.markwatson.search;

import com.markwatson.search.BingTranslate;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Unit test for NLP.
 */
public class TranslateTest extends TestCase {

  public TranslateTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(TranslateTest.class);
  }

  public void testTrfanslations() throws Exception {
    assertTrue(true);
    String query = "parrot";
    String json = BingTranslate.search(query, "english", "spanish");
    System.out.println(json);
    query = "parrot";
    json = BingTranslate.search(query, "english", "chinese");
    System.out.println(json);
    query = "good morning";
    json = BingTranslate.search(query, "english", "hungarian");
    System.out.println(json);
    json = BingTranslate.search("cat", "english", "portuguese");
    System.out.println(json);
  }

}
