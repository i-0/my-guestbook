# my-guestbook

generated using Luminus version "2.9.11.26"

From: http://www.luminusweb.net/docs

100% derivative work to follow sample guestbook app proposed as intro.

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.
Then run the following command to bootstrap the DB:

    lein run migrate
    
[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein run [-p <port>]

## Check JVM underpinnings

Generate jar file with all dependencies:

    lein uberjar

Then check jar contents:

    jar ft <uberjar file>

## Components overview (without any order)
- bouncer: validation based on state monad
- selmer: templating inspired by django
- compojure: routing
- xnio: Java NIO abstraction layer
- h2: SQL DB
- jackson: JSON parsing
- protobuf: binary serialization, what for? - hortnetq, see wunderboss
- wunderboss: immutant + X, not yet clear what it is?
- immutant: clojure libs for
  - web: undertow (HTTP server similar to bos-server!)
  - messaging: hornetq!
  - quartz: scheduling
  - infinispan: caching? (check it out)
  - narayana: transactions? (check it out)
- ring: HTTP API abstraction
- migratus: managing DB changes (migrate, rollack)
- joda time: sane date handling for java
- servlets: ?

Many more things...
