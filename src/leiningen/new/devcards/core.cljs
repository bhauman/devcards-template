(ns {{name}}.core
    (:require
     [devcards.core :as dc]
     #_[om.core :as om :include-macros true]
     #_[sablono.core :as sab :include-macros true])
    (:require-macros
     [devcards.core :refer [defcard is are= are-not=]]))

(enable-console-print!)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/devcards/index.html

;; I normally start developing with devcards in this file and then
;; move them into the examples_src/{{sanitized}}-devcards/core.cljs
;; file as work progresses.

(defcard {{name}}-intro-card
  (dc/markdown-card
   "# This is the first card for **{{ name }}**"
   "I can be found in `src/{{name}}/core.cljs`"
   "If you add cards to this file, they will appear here on this page."))

(println "If you change this line, you will see the result in the browser's console.")

