(ns frozen-smeagol.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [clojure.string :as s]
            [frozen-smeagol.transformer :refer [local-link-transformer]]
            [markdown.core :refer [md->html]]))

(defn show-content [title]
  (go
    (let [response
          (<! (http/get (str "/content/" title ".md")))
          content (js/document.getElementById "content")
          page-title (js/document.getElementById "page-title")]
      (set! (.-innerHTML page-title) title)
      (set!
        (.-innerHTML content)
        (local-link-transformer
          (md->html (:body response)))))))

(defn mount-components []
  (show-content "Introduction"))

(defn init! []
  (mount-components))

(defn ^:export click-handler [elt]
  (let [file-name (.-innerHTML elt)]
    (js/console.log (str "got " file-name))
    (show-content file-name)))

