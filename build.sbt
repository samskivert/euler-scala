organization := "com.samskivert"

name := "euler-scala"

version := "1.0-SNAPSHOT"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-unchecked", "-deprecation")

unmanagedSourceDirectories in Compile <+= baseDirectory

excludeFilter in unmanagedSources ~= { _ || "*.java" }
