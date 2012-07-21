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
