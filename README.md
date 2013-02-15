A wrapper for the new (2012) Microsoft Bing Web Search and Translate APIs
=========================================================================

You will need an auth token from Microsoft for search. Currently, 100 searches/day are free.
--------------------------------------------------------------------------------------------

I set the following in my environment:

BING_API_KEY=AQi3....kHAyAQ

Substitute your Microsoft BING API key.

For using the translation services you will also need an application key:

BING_API_APP=e12 ..... 413

You can get an App API key at https://datamarket.azure.com/developer/applications/

The free tranlation tier is currently 2 megabytes of translated text per month.

I also use this wrapper library in Clojure:
-------------------------------------------

```clojure
(ns knowledgespace.engine.search
  (:import [com.markwatson.search Bing])
  (:import [com.markwatson.search Translate]))
(use '[clojure.data.json :only (read-json)])

(defn search [query]
  (read-json (Bing/search query)))

(defn translate [text from-language to-language]
  (read-json (Bing/search query)))

```

You can extend the languages supported by editing the file Translate.java. For now, the to and from languages can be: "chinese", "french", "japanese", "hungarian", "spanish", "english", and "spanish".


```clojure
(ns test
  (:require [knowledgespace.engine.search :as search]))

(println (search/search "parrot"))

(println (search/translate "parrot" "english" "spanish"))
```

I then include the JAR file in my Clojure project using the kluge I mentioned in a blog article: http://blog.markwatson.com/2012/07/using-new-bing-web-search-api-from-java.html

Another way to integrate this wrapper in a Clojure lein project
---------------------------------------------------------------

For lein1 based projects, if I am not making frequent changes to Java code that I use in a Clojure project then I set the Java source path in my project.clj file:

```clojure
   :java-source-path "src/java"
```

and copy my Java code into PROJECT_DIR/src/java/



