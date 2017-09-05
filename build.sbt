name := "taxes"
version := "0.0.1"
scalaVersion := "2.12.1"
lazy val akkaVersion = "2.5.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

