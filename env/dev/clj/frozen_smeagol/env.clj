(ns frozen-smeagol.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [frozen-smeagol.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[frozen-smeagol started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[frozen-smeagol has shut down successfully]=-"))
   :middleware wrap-dev})
