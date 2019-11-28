
## Initialize postgreSQL database via docker

```
  cd docker_postgre
  docker build -t pg .
  docker run --rm -d  -p 5432:5432 --name docker-pg pg 
  cd ..
```

You can choose other name (as pg or docker-pg), if you want, but you have to be careful in changing name in the following section

## Test with micronaut

To create a docker with native image : 

```
  cd projects/micronaut_example
  mvn clean install ;  docker build -t micronaut_example .
```

To run the image : 
```
  docker run -p 8080:8080 --env POSTGRE_URL=$( docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' docker-pg  ) --name some-mn micronaut_example
```

To stop the image: 
```
  docker stop some-mn
```

## Test with quarkus 

To create a docker with native image : 

```
  cd projects/quarkus_example
  mvn package -Pnative -Dnative-image.docker-build=true
  docker build -f src/main/docker/Dockerfile.native -t quarkus_example .
```

To run the image : 
```
  docker run -p 8080:8080 --env POSTGRE_URL=$( docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' docker-pg  ) --name some-quarkus quarkus_example
```

To stop the image: 
```
  docker stop some-quarkus
```

## Test the images :

Go to :
http://localhost:8080/hello
http://localhost:8080/users

use :
```
curl -XPOST http://localhost:8080/users/guez/lionel   -H "Content-Type: application/json"
```

## To create an image with all project

See the file README.md in the folder create_image_linux 
