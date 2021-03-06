(defproject keechma-forms-example "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]
                 [json-html "0.4.7"]
                 [keechma/forms "0.1.6"]
                 [re-frame "0.11.0"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-marginalia "0.9.1"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles
  {:dev
   {:plugins [[lein-figwheel "0.5.19"]]

   }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "keechma-forms-example.core/reload"}
     :compiler     {:main                 keechma-forms-example.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true}}

    {:id           "dev-re-frame"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "keechma-forms-example.re-frame/reload"}
     :compiler     {:main                 keechma-forms-example.re-frame
                    :output-to            "resources/public/js/compiled/app-re-frame.js"
                    :output-dir           "resources/public/js/compiled/out-rf"
                    :asset-path           "js/compiled/out-rf"
                    :source-map-timestamp true}}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main          keechma-forms-example.core
                    :output-to     "resources/public/js/compiled/app.js"
                    :optimizations :advanced
                    :pretty-print  false}}

    ]})
