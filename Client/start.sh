#!/bin/bash

VERSION=1.0-SNAPSHOT

java -classpath \
    target/Client-$VERSION.jar:/home/petre/.m2/repository/Bursa/Interfata/$VERSION/Interfata-$VERSION.jar \
    com.bursa.client.Main -c
