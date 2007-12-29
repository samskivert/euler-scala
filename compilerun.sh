#!/bin/sh

if [ -z "$1" ]; then
    echo "Usage: $0 N"
    exit 255
fi

if [ ! -d classes ]; then
    mkdir classes
fi

echo "Compiling Euler$1.scala..."
scalac -deprecation -d classes Euler$1.scala
if [ $? != 0 ]; then
    exit $?
fi

echo "Running Euler$1..."
scala -cp classes Euler$1
