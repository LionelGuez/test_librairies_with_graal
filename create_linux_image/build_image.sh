#!/bin/bash

DIR=$( dirname $0 )


cd $DIR

DIR=$( pwd )

### CLEANUP ###
bash ./clean_image.sh
####


echo "#######################"
echo " Creating image"
echo "#######################"
echo ""
echo "This operation can be long"

set -e

mkdir docker_image
mkdir docker_image/jars
mkdir docker_image/exes


cd ../projects/spring_example
mvn clean install -Dmaven.test.skip=true
cp ./target/spring_example-*.jar $DIR/docker_image/jars
cd $DIR

cd ../projects/quarkus_example
mvn clean install -Pnative -Dnative-image.docker-build=true
cp ./target/quarkus-example*-runner.jar $DIR/docker_image/jars
cp ./target/quarkus-example*-runner     $DIR/docker_image/exes
cd $DIR

cd ../projects/micronaut_example
mvn clean install
cp ./target/micronaut-example*.jar  $DIR/docker_image/jars
cd $DIR
docker build --file ./Dockerfile.cross_micronaut -t cross_compile .
docker run  -v $( pwd )/../projects/micronaut_example/target:/home/app/micronaut-example cross_compile
ls ../projects/micronaut_example/target/micronaut-example
cp ../projects/micronaut_example/target/micronaut-example ./docker_image/exes/

docker build -t linux_system .
