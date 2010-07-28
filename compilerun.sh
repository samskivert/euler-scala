#!/bin/sh

if [ -z "$1" ]; then
    echo "Usage: $0 N"
    exit 255
fi

if [ ! -d classes ]; then
    mkdir classes
fi

printf -v NUM '%03d' $1
echo "Compiling Euler$NUM.scala..."
scalac -deprecation -d classes EulerApp.scala Euler$NUM.scala
if [ $? != 0 ]; then
    exit $?
fi

echo "Running Euler$NUM..."
TIME_OPTS="-f %E"
if [ `uname -s` = "Darwin" ]; then
    TIME_OPTS=""
fi
time $TIME_OPTS scala -cp classes Euler$NUM
