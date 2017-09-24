(ns frozen-smeagol.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[frozen-smeagol started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[frozen-smeagol has shut down successfully]=-"))
   :middleware identity})
