#!/bin/bash

cd /opt/source/Backend

mvn clean install -Dmaven.test.skip=true -q
