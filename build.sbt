name := "lift-akka"

version := "0.1"

scalaVersion := "2.9.2"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= {
  val liftVersion = "2.5-M1"
  val akkaVersion = "2.0.3"
  List(
    "net.liftweb" %% "lift-webkit" % liftVersion,
    "com.typesafe.akka" % "akka-actor" % akkaVersion,
    "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "container",
    "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default"
  )
}

seq(webSettings :_*)
