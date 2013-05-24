import com.markwatson.search.BingTranslate;

/**
 * author: Mark Watson
 */
public class TestTranslate {
  static public void main(String[] args) throws Exception {
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
