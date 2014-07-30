organization := "com.samskivert"

name := "euler-scala"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.2"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-optimize")

unmanagedSourceDirectories in Compile <+= baseDirectory

excludeFilter in unmanagedSources ~= { _ || "*.java" }
