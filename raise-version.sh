#!/bin/bash

# Updates all example artifact versions in all pom.xml files

# Update artifact versions in reactor POM and all modules POMs 
mvn --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules

# Update artifact versions in parent POMs 
mvn -f compile-test/crm.maven/config/pom.xml --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules
mvn -f deploy/application/maven/config/pom.xml  --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules
mvn -f docker/maven/config/pom.xml --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules

# Update artifacts parent version in reactor POM and all modules POMs
sed -i -b -E  "s:(^\s\s\s\s<version>)(.*)(<\/version>):\1${1}\3:g" $(find . -name "pom.xml")

# Update artifact version in Dockerfile
sed -i -b -E  "s:(ivy-application-)([0-9\.]+-SNAPSHOT)(\.zip):\1${1}\3:g" docker/image/Dockerfile
sed -i -b -E  "s;(ivy-application:)([0-9\.]+-SNAPSHOT);\1${1};g" docker/docker-compose.yml
