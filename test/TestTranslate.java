import com.markwatson.search.Translate;

/**
 * author: Mark Watson
 */
public class TestTranslate {
  static public void main(String[] args) throws Exception {
    String query = "parrot";
    String json = Translate.search(query, "english", "spanish");
    System.out.println(json);
    query = "parrot";
    json = Translate.search(query, "english", "chinese");
    System.out.println(json);
    query = "good morning";
    json = Translate.search(query, "english", "hungarian");
    System.out.println(json);
  }
}
