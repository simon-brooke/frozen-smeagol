(ns user
  (:require [mount.core :as mount]
            [frozen-smeagol.figwheel :refer [start-fw stop-fw cljs]]
            frozen-smeagol.core))

(defn start []
  (mount/start-without #'frozen-smeagol.core/repl-server))

(defn stop []
  (mount/stop-except #'frozen-smeagol.core/repl-server))

(defn restart []
  (stop)
  (start))


