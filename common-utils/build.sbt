
name := "common-utils"

version in ThisBuild := "0.0.1"

scalaVersion := "2.13.8"

val circeStack                     = Seq(
  "circe-core",
  "circe-generic",
  "circe-parser",
  "circe-literal",
  "circe-generic-extras"
).map("io.circe" %% _ % "0.13.0")


libraryDependencies in ThisBuild ++= circeStack

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Seq.empty
  )
