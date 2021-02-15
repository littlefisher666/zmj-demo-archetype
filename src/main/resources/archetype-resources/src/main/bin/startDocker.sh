#!/bin/sh
JAVA_OPTS="-Xms1024m -Xmx1024m -Xmn256m"
java $JAVA_OPTS -jar -Dspring.profiles.active=@profile@ @project.name@-@project.version@.jar