FROM library/postgres
ENV POSTGRES_USER docker
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB docker
COPY init.sql /docker-entrypoint-initdb.d/
#RUN ["psql", "-f", "/home/init.sql", "--username", "docker", "--dbname", "docker", "--password", "docker"]
