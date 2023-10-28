(ns build
  (:require [clojure.tools.build.api :as build]))

(def class-dir "target/classes")
(def basis (build/create-basis {:project "deps.edn"}))
(def jar-file "target/app.jar")

(defn clean
  (build/delete {:path "target"}))

(defn uberjar [_]
  (clean)
  (build/copy-dir {:src-dirs ["src"]
               :target-dir   class-dir})
  (build/compile-clj {:basis basis
                  :src-dirs  ["src"]
                  :class-dir class-dir})
  (build/uber {:class-dir class-dir
           :uber-file     jar-file
           :basis         basis
           :main          'je.oi.main}))