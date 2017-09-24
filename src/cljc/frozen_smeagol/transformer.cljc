(ns frozen-smeagol.transformer
  (:require [clojure.string :as s]))


(defn local-link-transformer
  [line]
  (s/replace
    (s/replace
     line
     #"\[\["
     "<a class='local-link' onclick='frozen_smeagol.core.click_handler(this)'>")
   #"\]\]" "</a>"))
