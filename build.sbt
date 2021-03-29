name := "objektwerks.geojson"
version := "0.1-SNAPSHOT"
scalaVersion := "2.11.12"
libraryDependencies ++= {
  Seq(
    "com.typesafe.play" %% "play-json" % "2.7.4",
    "com.typesafe.play.extras" %% "play-geojson" % "1.4.0",
    "org.slf4j" % "slf4j-api" % "1.7.25" % Test,
    "ch.qos.logback" % "logback-classic" % "1.2.3" % Test,
    "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )
}
scalacOptions ++= Seq(
  "-language:postfixOps",
  "-language:implicitConversions",
  "-language:reflectiveCalls",
  "-language:higherKinds",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Xfatal-warnings"
)
