#!/bin/bash

mvn -f maven/config/pom.xml --batch-mode versions:update-parent versions:commit -DparentVersion=${1} -DskipResolution=true -DallowSnapshots=true
