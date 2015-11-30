#!/bin/sh
# build libs first!
cd libs
mvn install -q -DskipTests=true
# switch back to parent
cd ..
# build parent
mvn install -q -DskipTests=true
mvn test
