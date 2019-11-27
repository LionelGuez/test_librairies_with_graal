FROM anapsix/alpine-java
RUN mkdir /jar
RUN mkdir /exes
COPY ./docker_image/jars/* /jar/
COPY ./docker_image/exes/* /exes/
CMD tail -f /dev/null
