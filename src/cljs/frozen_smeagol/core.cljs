(ns frozen-smeagol.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [clojure.string :as s]
            [markdown.core :refer [md->html]]))

(defn local-link-transformer
  [line state]
  (s/replace
    (s/replace
     line
     #"\[\["
     "<span class='local-link'>")
   #"\]\]" "</span>"))

(defn show-content [title]
  (go
   (let [response
         (<! (http/get (str "/content/" title ".md")))
         content (js/document.getElementById "content")]

    (set!
     (.-innerHTML content)
     (md->html
      (:body response)
      :custom-transformers [local-link-transformer])))))

(defn mount-components []
  (show-content "Introduction"))

(defn init! []
  (mount-components))


