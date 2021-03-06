(ns my-guestbook.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [my-guestbook.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[my-guestbook started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[my-guestbook has shut down successfully]=-"))
   :middleware wrap-dev})
