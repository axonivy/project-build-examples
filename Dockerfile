FROM maven:3.9.9-eclipse-temurin-17

RUN addgroup --gid 1000 build && adduser --uid 1000 --gid 1000 --disabled-password --gecos "" build
