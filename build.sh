#!/usr/bin/env bash

set -e
#npm install -g sass
#sass --update frontend/src/main/webapp/resources:src/main/webapp/resources --no-source-map
echo "Build the system"
mvn clean package -U -Dmaven.test.skip=true
#mvn clean install -pl backend -am -DskipTests=true




