FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/frozen-smeagol.jar /frozen-smeagol/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/frozen-smeagol/app.jar"]
