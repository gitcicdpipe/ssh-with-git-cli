## 1. Check for Existing SSH Keys

First, check if you already have SSH keys:

```bash
libraryDependencies ++= Seq(
  "tech.minna" %% "apigen-core" % "20.6.0",
  "tech.minna" %% "cogs" % cogsVersion,
  "tech.minna" %% "cogs-testkit" % cogsVersion % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "org.scalamock" %% "scalamock" % "7.5.0" % Test,
  "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % Test,
  "org.scalacheck" %% "scalacheck" % "1.19.0" % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.6.20" % Test,
  "com.typesafe.akka" %% "akka-http-testkit" % "10.2.10" % Test,
  "io.lettuce" % "lettuce-core" % "6.5.4.RELEASE"


  ("com.github.etaty" %% "rediscala" % "1.9.0")
    .exclude("com.typesafe.akka", "akka-actor")
    .exclude("com.typesafe.akka", "akka-stream")
    .exclude("com.typesafe.akka", "akka-slf4j")
)



```
