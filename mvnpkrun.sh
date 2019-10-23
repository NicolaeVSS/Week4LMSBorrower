#!/bin/bash

mvn clean package
java -jar ./target/lmsborrower-0.0.1-SNAPSHOT.jar
