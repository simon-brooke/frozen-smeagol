(ns frozen-smeagol.app
  (:require [frozen-smeagol.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
