#!/bin/bash

cd /opt/source/Backend

mvn clean install -Dmaven.test.skip=true -q

mv /opt/source/Backend/target/Backend-0.1.0.war /opt/tomcat8/webapps/
