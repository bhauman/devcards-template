(ns leiningen.new.devcards
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "devcards"))

(defn devcards
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info (str "Generating fresh 'lein new' devcards project.\n"
                    "cd into your project directory\n"
                    "Run 'lein figwheel' and then open localhost:3449/devcards/index.html in your browser."
                    ""))
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["devcards_src/{{sanitized}}_devcards/core.cljs" (render "devcards-core.cljs" data)]
             ["resources/public/devcards/index.html" (render "resources/index.html" data)]
             #_["resources/public/index.html" (render "resources/app-index.html" data)]
             ["resources/public/css/{{sanitized}}-style.css" (render "style.css" data)]             
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)])))
