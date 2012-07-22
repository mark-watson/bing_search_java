package com.markwatson.search;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * author: Mark Watson
 */
public class Bing {
  public static String search(String query) throws Exception {
    String bingUrl = "https://api.datamarket.azure.com/Bing/Search/Web?Query=%27" + java.net.URLEncoder.encode(query) + "%27&$format=JSON";
    
    String accountKey = System.getenv("BING_API_KEY");
    byte[] accountKeyBytes = Base64.encodeBase64((accountKey + ":" + accountKey).getBytes()); // code for encoding found on stackoverflow
    String accountKeyEnc = new String(accountKeyBytes);

    URL url = new URL(bingUrl);
    URLConnection urlConnection = url.openConnection();
    String s1 = "Basic " + accountKeyEnc;
    urlConnection.setRequestProperty("Authorization", s1);
    BufferedReader in = new BufferedReader(new InputStreamReader(
        urlConnection.getInputStream()));
    String inputLine;
    StringBuffer sb = new StringBuffer();
    while ((inputLine = in.readLine()) != null)
      System.out.println(inputLine);
    sb.append(inputLine);
    in.close();
    return sb.toString();
  }
}
