(defproject example "0.1.0-SNAPSHOT"
  :description "Bug example"
  :dependencies [[org.clojure/clojure "1.9.0"]

                 [metosin/compojure-api "2.0.0-alpha27"]

                 [org.clojure/spec.alpha "0.2.176"]
                 [org.clojure/core.specs.alpha "0.2.44"]]

  :ring {:handler      app.core/handler
         :auto-reload? true}

  :profiles {:dev {:plugins [[lein-ring "0.12.4"]]}})