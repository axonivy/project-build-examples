#!/bin/bash

# Updates all example artifact versions in all pom.xml files
# Update artifact versions in reactor POM and all modules POMs 
mvn --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules
mvn -f deploy/single-project/pom.xml --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules
mvn -f deploy/single-project-over-http/pom.xml --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules

# Update artifact versions in parent POMs 
mvn -f compile-test/crm.maven/config/pom.xml --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules
mvn -f deploy/application/maven/config/pom.xml  --batch-mode versions:set versions:commit -DnewVersion=${1} -DprocessAllModules
# Update artifacts parent version in reactor POM and all modules POMs
sed -i -b -E  "s:(^\s\s\s\s<version>)(.*)(<\/version>):\1${1}\3:g" $(find . -name "pom.xml")
