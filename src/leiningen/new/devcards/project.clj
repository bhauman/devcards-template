(defproject {{ name }} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [org.clojure/core.async "0.1.278.0-76b25b-alpha"]]

  :profiles { :dev {:dependencies [[markdown-clj "0.9.43"]
                                   [sablono "0.2.16"]
                                   [crate "0.2.4"]
                                   [jayq "2.4.0"]
                                   [om "0.6.2"]
                                   [frontier "0.1.0-SNAPSHOT"] ;; XXX
                                   [figwheel "0.1.2-SNAPSHOT"] ;; XXX
                                   [devcards "0.1.0-SNAPSHOT"]]
                    :plugins [[lein-cljsbuild "1.0.3"]
                              [lein-figwheel "0.1.2-SNAPSHOT"]] }}
  
  :source-paths ["src"]

  :cljsbuild { 
              :builds [{:id "{{ sanitized }}-devcards"
                        :source-paths ["devcards_src" "src"]
                        :compiler {
                                   :output-to "resources/public/devcards/js/compiled/{{sanitized}}_devcards.js"
                                   :output-dir "resources/public/devcards/js/compiled/out"
                                   :optimizations :none
                                   :source-map true}}]}
  
  :figwheel { :css-dirs ["resources/public/css"] })

