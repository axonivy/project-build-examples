#!/bin/bash

mvn --batch-mode versions:set -DnewVersion=${1} -DprocessAllModules
