import com.markwatson.search.Bing;

/**
 * author: Mark Watson
 */
public class Test {
  static public void main(String[] args) throws Exception {
    String query = "parrot";
    String json = Bing.search(query);
    System.out.println(json);
  }
}
