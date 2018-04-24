name := """bookstoreapp-JoshuaZhang1105"""
organization := "ca.ycdsb"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
// lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += guice
// libraryDependencies += "com.h2database" % "h2" % "1.4.192"
// libraryDependencies += javaJdbc
