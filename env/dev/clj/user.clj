(ns user
  (:require [mount.core :as mount]
            my-guestbook.core))

(defn start []
  (mount/start-without #'my-guestbook.core/http-server
                       #'my-guestbook.core/repl-server))

(defn stop []
  (mount/stop-except #'my-guestbook.core/http-server
                     #'my-guestbook.core/repl-server))

(defn restart []
  (stop)
  (start))


