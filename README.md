A wrapper for the new (2012) Microsoft Bing Web Search, Translate and Spelling Correction APIs
==============================================================================================


You will need an auth token from Microsoft for search. Currently, 100 searches/day are free. You will need a separate spelling API key if you want to use the spell check wrapper. You will also need an API APP key for translation.

Once you have the environment variables BING_API_KEY and BING_SPELLING_KEY set, try running the "tests":

        mvn clean test

## I set the following in my environment for search:

BING_API_KEY=AQi3....kHAyAQ

Substitute your Microsoft BING API key.

## For spelling correction, set:

BING_SPELLING_KEY= pqDGHS...tuYtss=

(again, substitute your key)

## For using the translation services you will also need an application key:

BING_API_APP=e12 ..... 413

You can get an App API key at https://datamarket.azure.com/developer/applications/

The free translation tier is currently 2 megabytes of translated text per month.

I wrote the search and spelling wrappers myself. For translation, I use the wrapper from uses library from:  https://code.google.com/p/microsoft-translator-java-api/


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


## notes for local maven install:

➜  bing_search_java git:(master) ✗ lein localrepo install bing.jar local/bing 0.1.0
➜  bing_search_java git:(master) ✗ lein localrepo list | grep bing
local/bing (0.1.0)



