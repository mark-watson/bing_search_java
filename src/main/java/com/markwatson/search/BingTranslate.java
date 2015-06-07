package com.markwatson.search;

import com.memetix.mst.language.Language;

// uses library from:  https://code.google.com/p/microsoft-translator-java-api/

/**
 * author: Mark Watson
 */
public class BingTranslate {
  public static String search(String text, String from_language, String to_language) throws Exception {
    // Set your Windows Azure Marketplace client info - See http://msdn.microsoft.com/en-us/library/hh454950.aspx
    // register application at: https://datamarket.azure.com/developer/applications/
    System.out.println("BING_API_APP: " + System.getenv("BING_API_APP"));
    System.out.println("BING_API_KEY: " + System.getenv("BING_API_KEY"));
    com.memetix.mst.translate.Translate.setClientId(System.getenv("BING_API_APP"));
    com.memetix.mst.translate.Translate.setClientSecret(System.getenv("BING_API_KEY"));
    Language from = Language.ENGLISH;
    Language to = Language.ENGLISH;
    if (from_language.equals("chinese")) from = Language.CHINESE_SIMPLIFIED;
    if (from_language.equals("french")) from = Language.FRENCH;
    if (from_language.equals("japanese")) from = Language.JAPANESE;
    if (from_language.equals("hungarian")) from = Language.HUNGARIAN;
    if (from_language.equals("spanish")) from = Language.SPANISH;
    if (to_language.equals("chinese")) to = Language.CHINESE_SIMPLIFIED;
    if (to_language.equals("french")) to = Language.FRENCH;
    if (to_language.equals("japanese")) to = Language.JAPANESE;
    if (to_language.equals("hungarian")) to = Language.HUNGARIAN;
    if (to_language.equals("spanish")) to = Language.SPANISH;
    if (to_language.equals("thai")) to = Language.THAI;
    if (to_language.equals("greek")) to = Language.GREEK;
    if (to_language.equals("vietnamese")) to = Language.VIETNAMESE;
    if (to_language.equals("chinese_traditional")) to = Language.CHINESE_TRADITIONAL;
    if (to_language.equals("portuguese")) to = Language.PORTUGUESE;
    String translatedText = com.memetix.mst.translate.Translate.execute(text, from, to);

    System.out.println(translatedText);
    return translatedText;
  }
}
