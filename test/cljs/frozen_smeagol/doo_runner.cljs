(ns frozen-smeagol.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [frozen-smeagol.core-test]))

(doo-tests 'frozen-smeagol.core-test)

