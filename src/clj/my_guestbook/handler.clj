(ns my-guestbook.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [my-guestbook.layout :refer [error-page]]
            [my-guestbook.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [my-guestbook.env :refer [defaults]]
            [mount.core :as mount]
            [my-guestbook.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
