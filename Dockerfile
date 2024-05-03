From maven:latest AS base
WORKDIR /project

From base AS build
WORKDIR /project
COPY . .
RUN mvn clean compile


From build AS test
WORKDIR /project
CMD ["mvn","test","-PSmoke"]
