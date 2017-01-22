(ns my-guestbook.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[my-guestbook started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[my-guestbook has shut down successfully]=-"))
   :middleware identity})
