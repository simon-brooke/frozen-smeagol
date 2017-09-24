(ns frozen-smeagol.routes.home
  (:require [clojure.java.io :as io]
            [compojure.core :refer [defroutes GET]]
            [frozen-smeagol.layout :as layout]
            [frozen-smeagol.transformer :refer [local-link-transformer]]
            [markdown.core :as md]
            [ring.util.http-response :as response]))

(defn home-page []
  (layout/render
    "home.html"
    {:header
     (local-link-transformer
       (md/md-to-html-string
         (slurp (io/resource "public/content/_header.md"))))
     :side-bar
     (local-link-transformer
       (md/md-to-html-string
         (slurp (io/resource "public/content/_side-bar.md"))))}))

(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/docs" []
       (-> (response/ok (-> "docs/docs.md" io/resource slurp))
           (response/header "Content-Type" "text/plain; charset=utf-8"))))


(io/resource "public/content/_side-bar.md")
