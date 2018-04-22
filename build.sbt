name := "db-utils"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "com.h2database" % "h2" % "1.4.197" % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "org.mockito" % "mockito-core" % "2.18.0" % Test
)
