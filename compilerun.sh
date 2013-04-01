#!/bin/bash

if [ -z "$1" ]; then
    echo "Usage: $0 N"
    exit 255
fi

mkdir -p target/classes

printf -v NUM '%03d' $1
echo "Compiling Euler$NUM.scala..."
scalac -deprecation -d target/classes EulerApp.scala Euler$NUM.scala
if [ $? != 0 ]; then
    exit $?
fi

echo "Running Euler$NUM..."
time scala -cp target/classes Euler$NUM
