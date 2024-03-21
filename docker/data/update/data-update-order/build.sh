#!/bin/bash
cd ../../../../services/data/update/data-update-order/ || exit
./gradlew clean build
./gradlew publishToMavenLocal
docker build -t aalfrihat/data-update-order:1.0.0 .
