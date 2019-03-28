(defproject {{ name }} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  {{#java9?}} ;; This Figwheel project was generated with Java 9
              ;; and ClojureScript currently needs this flag added to the compiler
              ;; under Java 9
  :jvm-opts ["--add-modules" "java.xml.bind"]{{/java9?}}

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [devcards "0.2.6"]
                 [sablono "0.8.5"]

                 ;; need to specify this for sablono
                 ;; when not using devcards
                 [cljsjs/react "16.8.3-0"]
                 [cljsjs/react-dom "16.8.3-0"]
                 #_[org.omcljs/om "1.0.0-beta1"]
                 #_[reagent "0.8.1"]
                 ]

  :plugins [[lein-figwheel "0.5.18"]
            [lein-cljsbuild "1.1.7" :exclusions [org.clojure/clojure]]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]

  :source-paths ["src"]

  :cljsbuild {
              :builds [{:id "devcards"
                        :source-paths ["src"]
                        :figwheel { :devcards true  ;; <- note this
                                   ;; :open-urls will pop open your application
                                   ;; in the default browser once Figwheel has
                                   ;; started and compiled your application.
                                   ;; Comment this out once it no longer serves you.
                                   :open-urls ["http://localhost:3449/cards.html"]}
                        :compiler { :main       "{{name}}.core"
                                    :asset-path "js/compiled/devcards_out"
                                    :output-to  "resources/public/js/compiled/{{sanitized}}_devcards.js"
                                    :output-dir "resources/public/js/compiled/devcards_out"
                                    :source-map-timestamp true }}
                       {:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main       "{{name}}.core"
                                   :asset-path "js/compiled/out"
                                   :output-to  "resources/public/js/compiled/{{sanitized}}.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :source-map-timestamp true }}
                       {:id "prod"
                        :source-paths ["src"]
                        :compiler {:main       "{{name}}.core"
                                   :asset-path "js/compiled/out"
                                   :output-to  "resources/public/js/compiled/{{sanitized}}.js"
                                   :optimizations :advanced}}]}

  :figwheel { :css-dirs ["resources/public/css"] }

  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.10"]
                                  [figwheel-sidecar "0.5.18"]
                                  [cider/piggieback "0.4.0"]]
                   ;; need to add dev source path here to get user.clj loaded
                   :source-paths ["src" "dev"]
                   ;; for CIDER
                   ;; :plugins [[cider/cider-nrepl "0.12.0"]]
                   :repl-options {; for nREPL dev you really need to limit output
                                  :init (set! *print-length* 50)
                                  :nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}})
