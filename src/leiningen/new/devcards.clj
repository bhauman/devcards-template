(ns leiningen.new.devcards
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "devcards"))

(defn devcards
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (when (= name "devcards")
      (main/abort
       (str "Cannot name a devcards project \"devcards\" the namespace will clash.\n"
            "You should never name your project after a library you depend on."
            "Please choose a different name, maybe \"devcardtry\"?")))
    (main/info (str "Generating fresh 'lein new' devcards project.\n"
                    "cd into '" name "'\n"
                    "Run 'lein figwheel' and then open http://localhost:3449/cards.html in your browser."
                    ""))
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["resources/public/cards.html" (render "resources/index.html" data)]
             ["resources/public/index.html" (render "resources/app_index.html" data)]             
             ["resources/public/css/{{sanitized}}_style.css" (render "style.css" data)]             
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)])))
