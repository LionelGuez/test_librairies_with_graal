
# The goal of this folder is to create a docker image with all solutions.

## Create the image 
```
bash ./build_image.sh
```

*Warning* : This command can be long

## Start the image 

*Warning* : the 'docker-pg' must be running (see README.md of the parent folder)
*Warning* : the port 8080 must be free (but you can change the port in changing the following command)

To start the image, use the following command : 
```
docker run --rm -d -p  8080:8080  --env POSTGRE_URL=$( docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' docker-pg  ) --name some-linux linux_system 
```
The image is executed in the background

## Start a shell inside the container

To start a container : 
```
docker exec -it some-linux /bin/sh
```

### Stop the image
To stop the container
```
docker stop some-linux
```

## Folder inside image
In this image, two folders are importants : 
 * the folder /jar which contains all java solutions. To execute them with command ``` java -jar <jar file>  ``` 
 * the folder /exex which contains all natives solutions. To execute them with command ``` ./<executables> ```
 
