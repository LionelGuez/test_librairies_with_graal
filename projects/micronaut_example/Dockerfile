FROM oracle/graalvm-ce:19.2.0.1 as graalvm
COPY . /home/app/micronaut-example
WORKDIR /home/app/micronaut-example
RUN gu install native-image
RUN native-image --no-server -cp target/micronaut-example-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-example .
ENTRYPOINT ["./micronaut-example"]
