name := "lift-akka-sample-remote-service"

version := "0.1"

scalaVersion := "2.9.2"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= {
  val akkaVersion = "2.0.3"
  List(
    "com.typesafe.akka" % "akka-actor" % akkaVersion,
    "com.typesafe.akka" % "akka-remote" % akkaVersion,
    "com.typesafe.akka" % "akka-kernel" % akkaVersion
  )
}
