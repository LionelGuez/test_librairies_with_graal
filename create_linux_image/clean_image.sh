#!/bin/bash

echo "Cleaning image"

rm -rf docker_image
docker image rm linux_system  &> /dev/null || true
docker container ls -a | grep cross_compile | awk '{print $NF}'  | xargs docker container rm &> /dev/null
docker image rm cross_compile  &> /dev/null || true
