(ns app.core
  (:require [compojure.api.sweet :as c]
            [ring.util.http-response :as r]
            [clojure.spec.alpha :as s]))

(s/def ::foo string?)
(s/def ::foo-result ::foo)
(s/def ::foo-result-map (s/keys :req-un [::foo-result]))

(s/def ::result string?)
(s/def ::result-map (s/keys :req-un [::result]))

(def handler
  (c/api
    {:swagger
     {:ui   "/"
      :spec "/swagger.json"}}
    (c/context "/api" []
      :coercion :spec

      (c/GET "/foo-result-map" []
        :summary "Fails"
        :return ::foo-result-map
        (r/ok {:foo-result "some result"}))

      (c/POST "/process-foo-result-map" []
        :summary "Fails"
        :body [item ::foo-result-map]
        (r/ok item))

      (c/GET "/result-map" []
        :summary "Works"
        :return ::result-map
        (r/ok {:result "some result"}))

      (c/POST "/process-result-map" []
        :summary "Works"
        :body [item ::result-map]
        (r/ok item))

      (c/GET "/foo-result" []
        :summary "Works"
        :return ::foo-result
        (r/ok "some result"))

      (c/GET "/result" []
        :summary "Works"
        :return ::result
        (r/ok "some result")))))