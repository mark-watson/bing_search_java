import com.markwatson.search.Bing;
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
