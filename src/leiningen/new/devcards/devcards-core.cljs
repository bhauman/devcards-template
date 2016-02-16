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
;; http://localhost:3449/cards.html

(defcard devcard-intro
  (dc/markdown-card
   "# Devcards for {{ name }}

    I can be found in `devcards_src/{{sanitized}}_devcards/core.cljs`.

    If you add cards to this file, they will appear here on this page.
    As you add cards to other namespaces, those namespaces will
    be listed on the Devcards **home** page, provided you require 
    those files in `devcards_src/{{sanitized}}_devcards/core.cljs`.

    You can add devcards to any file as long as you require
    `devcards.core` like so:

    ```
    (:require [devcards.core :as dc :include-macros true])
    ```

    <a href=\"https://github.com/bhauman/devcards/blob/master/example_src/devdemos/core.cljs\" target=\"_blank\">Here are some Devcard examples</a>"))

