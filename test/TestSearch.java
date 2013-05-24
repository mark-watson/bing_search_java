import com.markwatson.search.BingSearch;

/**
 * author: Mark Watson
 */
public class TestSearch {
  static public void main(String[] args) throws Exception {
    String query = "the parot talks a lot";
    String json = BingSearch.search(query);
    System.out.println(json);
  }
}
