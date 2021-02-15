#!/bin/bash
APP_MAINCLASS=@project.name@-@project.version@.jar

pid=`ps -ef | grep $APP_MAINCLASS | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
    echo "kill pid $pid."
    kill -9 $pid
    if [ $? -eq 0 ]
    then
         echo "[OK]"
    else
         echo "[Failed]"
    fi
else
    echo "warn $APP_MAINCLASS is not running."
fi 
