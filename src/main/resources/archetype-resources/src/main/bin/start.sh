#!/bin/bash
APP_PATH=/root/@project.name@
APP_MAINCLASS=@project.name@-@project.version@.jar
JAVA_OPTS="-Xms1024m -Xmx1024m -Xmn256m -XX:MaxPermSize=128m"

pid=`ps -ef | grep $APP_MAINCLASS | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]; then
    echo "warn: $APP_MAINCLASS already started! (pid=$pid)"
else
    echo -n "Starting $APP_MAINCLASS ..."
if [ ! -d "$APP_PATH/logs" ]; then
   mkdir $APP_PATH/logs
fi
    nohup java $JAVA_OPTS -jar $APP_PATH/$APP_MAINCLASS >/dev/null 2>&1 &
    sleep 1
    pid=`ps -ef | grep $APP_MAINCLASS | grep -v grep | awk '{print $2}'`
    if [ -n "$pid" ]; then
        echo "$APP_MAINCLASS start. (pid=$pid)"
    else
        echo "$APP_MAINCLASS start failed."
    fi
fi 
