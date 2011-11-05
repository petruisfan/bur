#!/bin/bash

VERSION=1.0-SNAPSHOT

java -classpath \
    /home/petre/.m2/repository/Bursa/Interfata/$VERSION/Interfata-$VERSION.jar:target/Server-$VERSION.jar \
    com.bursa.Main
