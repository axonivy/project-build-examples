#!/bin/bash
set -e

# Updates all example artifact versions in all pom.xml files

# Update artifact versions in reactor POM and all modules POMs 
mvn --batch-mode -f maven/pom.xml versions:set versions:commit -DnewVersion=${1} -DprocessAllModules

# Update artifact version in Dockerfile
sed -i -b -E  "s:(ivy-application-)([0-9\.]+-SNAPSHOT)(\.zip):\1${1}\3:g" docker/image/Dockerfile
sed -i -b -E  "s;(ivy-application:)([0-9\.]+-SNAPSHOT);\1${1};g" docker/compose.yml
