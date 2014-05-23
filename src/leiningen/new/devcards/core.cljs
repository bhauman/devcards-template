(ns {{name}}.core
    (:require
     #_[devcards.core :as dc :include-macros true]
     #_[om.core :as om :include-macros true]
     #_[sablono.core :as sab :include-macros true])
    #_(:require-macros
       [devcards.core :refer [defcard is are= are-not=]]))

(enable-console-print!)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/devcards/index.html

