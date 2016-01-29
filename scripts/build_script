#!/bin/bash

cd /opt/source/Backend

mvn clean install -Dmaven.test.skip=true -q
STATUS=$?
    if [[ $STATUS -eq 0 ]];
    then
        echo "[+] Built successfully."


mv /opt/source/Backend/target/Backend-0.1.0.war /opt/tomcat8/webapps/Backend.war

/opt/tomcat8/bin/shutdown.sh

