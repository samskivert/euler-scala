#!/bin/sh

if [ ! -d classes ]; then
    mkdir classes
fi
scalac -deprecation -d classes EulerGen.scala

scala -cp classes EulerGen $*
