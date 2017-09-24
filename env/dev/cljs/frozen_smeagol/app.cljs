(ns ^:figwheel-no-load frozen-smeagol.app
  (:require [frozen-smeagol.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
