(ns my-guestbook.routes.home
  (:require [my-guestbook.layout :as layout]
            [my-guestbook.db.core :as db]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [ring.util.response :refer [redirect]]
            [clojure.java.io :as io]
            [bouncer.core :as b]
            [bouncer.validators :as v]))

(defn home-page [{:keys [flash]}]
  (layout/render
   "home.html"
   (merge {:messages (db/get-messages)}
           (select-keys flash [:name :message :errors]))))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" request (home-page request))
  (POST "/" request (save-message! request))
  (GET "/about" [] (about-page)))

(defn validate-message [params]
  (first
   (b/validate
    params
    :name v/required
    :message [v/required [v/min-count 10]])))

(defn save-message! [{:keys [params]}]
  (if-let [errors (validate-message params)]
    (-> (response/found "/")
        (assoc :flash (assoc params :errors errors)))
    (do
      (db/save-message!
       (assoc params :timestamp (java.util.Date.)))
      (response/found "/"))))
