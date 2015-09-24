package com.markwatson.search;

import com.markwatson.search.BingSearch;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Unit test for NLP.
 */
public class SearchTest extends TestCase {

  public SearchTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(SearchTest.class);
  }


  public void testSearch() throws Exception {
    assertTrue(true);
    String query = "the parot talks a lot";
    String json = BingSearch.search(query);
    System.out.println(json);
	
	// results as a List<List<String>>. Inner list contains strings for: title, description, url, date
	List<List<String>> results = BingSearchJavaResults.search("meyers parrot");
	System.out.println(results);
  }

}
