-- :name save-message! :! :n
-- :doc creates a new user record
INSERT INTO guestbook
(name, message, timestamp)
VALUES (:name, :message, :timestamp)

-- :name get-messages :? :*
-- :doc selects all stored messages
SELECT * FROM guestbook
