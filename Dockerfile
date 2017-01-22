FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/my-guestbook.jar /my-guestbook/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/my-guestbook/app.jar"]
