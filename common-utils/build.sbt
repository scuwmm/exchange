
name := "common-utils"

version in ThisBuild := "0.0.1"

scalaVersion := "2.13.8"

val circeStack = Seq(
  "circe-core",
  "circe-generic",
  "circe-parser",
  "circe-literal",
  "circe-generic-extras"
).map("io.circe" %% _ % "0.13.0")

val akkaVersion = "2.6.14"
val akkaStack = Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-discovery" % akkaVersion,
  "com.typesafe.akka" %% "akka-pki" % akkaVersion
)

val akkaHttpVersion = "10.2.6"
val akkaHttpStack = Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http2-support" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
)

libraryDependencies in ThisBuild ++= circeStack ++ akkaStack ++ akkaHttpStack

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Seq.empty
  )
