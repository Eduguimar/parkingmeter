# docker build -f Dockerfile -t parkingmeter-local .
# docker run -p 5432:5432 -v $(pwd):/parkingmeter/ parkingmeter-local
FROM postgres:latest

ENV POSTGRES_DB comein
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432