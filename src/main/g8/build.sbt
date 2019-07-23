name := """$name$"""
organization := "$organization$"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("src/main/."))
  .settings(settings)
  .enablePlugins(PlayScala)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)

resolvers += Resolver.sonatypeRepo("snapshots")

routesGenerator := InjectedRoutesGenerator

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)

lazy val settings = Seq(
  scalaVersion := "2.12.8",
  libraryDependencies ++= List(
    guice,

    // Play Extensions
    "com.typesafe.play" %% "play-slick" % "3.0.0",
    "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0",
    "com.typesafe.play" %% "play-iteratees" % "2.6.1",
    "com.typesafe.play" %% "play-iteratees-reactive-streams" % "2.6.1",
    "com.typesafe.play" %% "play-json" % "2.6.6",

    // Swagger API
    "io.swagger" %% "swagger-play2" % "1.7.1",
    "org.webjars"  %  "swagger-ui" % "3.2.2",
    "io.swagger" %% "swagger-scala-module" % "1.0.3",

    // ORM
    "mysql" % "mysql-connector-java" % "5.1.41",

    // TEST
    "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test,

    // DI Wire
    "com.softwaremill.macwire" %% "macros" % "2.3.1" % "provided",

  )

)

//
sources in doc in Compile := List()



