A wrapper for the new (2012) Microsoft Bing Web Search API
==========================================================

You will need an auth token from Microsoft. Currently, 100 searches/day are free.
---------------------------------------------------------------------------------

I set the following in my environment:

BING_API_KEY=AQi3....kHAyAQ

Substitute your Microsoft BING API key.

I also use this wrapper library in Clojure:
-------------------------------------------

```clojure
(ns knowledgespace.engine.search
  (:import [com.markwatson.search Bing]))
(use '[clojure.data.json :only (read-json)])

(defn search [query]
  (read-json (Bing/search query)))
```

```clojure
(ns test
  (:require [knowledgespace.engine.search :as search]))

(println (search/search "parrot"))
```

I then include the JAR file in my Clojure project using the kluge I mentioned in a blog article: http://blog.markwatson.com/2012/07/using-new-bing-web-search-api-from-java.html

Another way to integrate this wrapper in a Clojure lein project
---------------------------------------------------------------

For lein1 based projects, if I am not making frequent changes to Java code that I use in a Clojure project then I set the Java sorce path in my project.clj file:

```clojure
   :java-source-path "src/java"
```

and copy my Java code into PROJECT_DIR/src/java/

