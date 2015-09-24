package com.markwatson.search;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * author: Mark Watson Copyright 2011-2015. Apache 2 license. Source: https://github.com/mark-watson/bing_search_java
 *
 * result: List<List<String>>. Inner list contains strings for: title, description, url, date
 */
public class BingSearchJavaResults {

  public static List<List<String>> search(String query) throws Exception {

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
      sb.append(inputLine);
    in.close();
    String json = sb.toString();
    JSONObject d= (JSONObject)((Map)JSONValue.parse(json)).get("d");
    JSONArray results = (JSONArray)d.get("results");
    int result_size = results.size();
    List<List<String>> theResults = new ArrayList<>();
    for (int i=0; i<result_size; i++) {
      JSONObject result = (JSONObject)results.get(i);
      String description = (String)result.get("Description");
      String title = (String)result.get("Title");
      String url2 = (String)result.get("Url");
      String date = (String)result.get("Date");
      theResults.add(Arrays.asList(title, description, url2, date));
    }
    return theResults;
  }
}
