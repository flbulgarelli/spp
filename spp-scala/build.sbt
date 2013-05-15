name := "spp-scala"

version := "1.0.0-SNAPSHOT"

organization := "spp"

scalaVersion := "2.10.1"

resolvers += "Local Maven" at Path.userHome.asFile.toURI.toURL + ".m2/repository"

libraryDependencies ++= Seq(
 "spp" % "spp-core" % "1.0-SNAPSHOT",
 "org.scalatest" % "scalatest_2.10.0-RC5" % "2.0.M5-B1" % "test"
)


