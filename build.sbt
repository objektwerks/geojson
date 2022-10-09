name := "objektwerks.geojson"
version := "0.1-SNAPSHOT"
scalaVersion := "2.11.12"
libraryDependencies ++= {
  Seq(
    "com.typesafe.play" %% "play-json" % "2.5.19", // Don't ever change this version!
    "com.typesafe.play.extras" %% "play-geojson" % "1.4.0",
    "org.slf4j" % "slf4j-api" % "2.0.3" % Test,
    "ch.qos.logback" % "logback-classic" % "1.4.3" % Test,
    "org.scalatest" %% "scalatest" % "3.2.14" % Test
  )
}
