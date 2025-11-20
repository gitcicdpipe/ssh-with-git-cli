name := "models"
ThisBuild / organization := "tech.minna"
ThisBuild / scalaVersion := "2.13.17"
ThisBuild / crossScalaVersions := Seq("2.13.17")
scalacOptions := tech.minna.sbt.plugin.fresh.ScalaCompilerFlags.allBestPractices(VersionNumber(scalaVersion.value))
scalacOptions += "-Xsource:3"
enablePlugins(MinnaLibraryPlugin, GitVersioningPlugin)

val cogsVersion = "28.4.0"

libraryDependencies ++= Seq(
  // Explicitly declare the versions you want to use
  "com.typesafe.akka" %% "akka-actor" % "2.6.20",
  "com.typesafe.akka" %% "akka-stream" % "2.6.20",
  "com.typesafe.akka" %% "akka-http" % "10.2.10",
  "com.typesafe.akka" %% "akka-http-core" % "10.2.10",
  "com.typesafe.play" %% "play-json" % "2.10.7",
  "com.google.guava" % "guava" % "33.4.0-jre",
  "org.slf4j" % "slf4j-api" % "2.0.17",
  "com.lihaoyi" %% "sourcecode" % "0.3.0",
  "com.google.api.grpc" % "proto-google-cloud-kms-v1" % "0.169.0",
  
  // Your dependencies with exclusions
  ("tech.minna" %% "apigen-core" % "20.6.0")
    .excludeAll(
      ExclusionRule(organization = "com.typesafe.akka"),
      ExclusionRule(organization = "com.typesafe.play"),
      ExclusionRule(organization = "com.google.guava"),
      ExclusionRule(organization = "com.google.api.grpc"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "com.lihaoyi")
    ),
  
  ("tech.minna" %% "cogs" % cogsVersion)
    .excludeAll(
      ExclusionRule(organization = "com.typesafe.akka"),
      ExclusionRule(organization = "com.typesafe.play"),
      ExclusionRule(organization = "com.google.guava"),
      ExclusionRule(organization = "com.google.api.grpc"),
      ExclusionRule(organization = "com.google.cloud"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "ch.qos.logback"),
      ExclusionRule(organization = "com.fasterxml.jackson.core"),
      ExclusionRule(organization = "com.fasterxml.jackson.datatype"),
      ExclusionRule(organization = "com.lihaoyi"),
      ExclusionRule(organization = "commons-codec")
    ),
  
  ("tech.minna" %% "cogs-testkit" % cogsVersion % Test)
    .excludeAll(
      ExclusionRule(organization = "com.typesafe.akka"),
      ExclusionRule(organization = "com.typesafe.play"),
      ExclusionRule(organization = "com.google.guava"),
      ExclusionRule(organization = "org.slf4j")
    ),
  
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "org.scalamock" %% "scalamock" % "7.5.0" % Test,
  "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % Test,
  "org.scalacheck" %% "scalacheck" % "1.19.0" % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.6.20" % Test,
  "com.typesafe.akka" %% "akka-http-testkit" % "10.2.10" % Test
)

useCoursier := false
Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oDG")
ThisBuild / githubOwner := "minna-technologies"
ThisBuild / githubRepository := "models"
ThisBuild / publishMavenStyle := true
