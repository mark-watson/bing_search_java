import com.markwatson.search.BingSpelling;

/**
 * author: Mark Watson
 */
public class TestSpelling {
  static public void main(String[] args) throws Exception {
    String query = "the parot talks a lot";
    String json = BingSpelling.spelling(query);
    System.out.println(json);
  }
}
