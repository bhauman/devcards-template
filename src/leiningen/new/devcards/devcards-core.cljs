(ns {{name}}-devcards.core
    (:require
     [devcards.core :as dc :include-macros true]
     [{{name}}.core :as {{name}}] 
     #_[om.core :as om :include-macros true]
     #_[sablono.core :as sab :include-macros true])
    (:require-macros
     [devcards.core :refer [defcard is are= are-not=]]))

(enable-console-print!)

(devcards.core/start-devcard-ui!)
(devcards.core/start-figwheel-reloader!)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/devcards/index.html

(defcard devcard-intro
  (dc/markdown-card
   "# Devcards for {{ name }}

    I can be found in `devcards_src/{{sanitized}}_devcards/core.cljs`.

    If you add cards to this file, they will appear here on this page."))

