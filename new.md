## 1. Check for Existing SSH Keys

First, check if you already have SSH keys:

```bash
// Force specific Akka versions
dependencyOverrides ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.6.20",
  "com.typesafe.akka" %% "akka-stream" % "2.6.20",
  "com.typesafe.akka" %% "akka-http" % "10.2.10",
  "com.typesafe.akka" %% "akka-http-core" % "10.2.10"
)

// Exclude from non-test dependencies if not needed
libraryDependencies ++= Seq(
  ("tech.minna" %% "apigen-core" % "20.6.0")
    .excludeAll(ExclusionRule(organization = "com.typesafe.akka")),
  ("tech.minna" %% "cogs" % cogsVersion)
    .excludeAll(ExclusionRule(organization = "com.typesafe.akka")),
  "tech.minna" %% "cogs-testkit" % cogsVersion % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "org.scalamock" %% "scalamock" % "7.5.0" % Test,
  "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % Test,
  "org.scalacheck" %% "scalacheck" % "1.19.0" % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.6.20" % Test,
  "com.typesafe.akka" %% "akka-http-testkit" % "10.2.10" % Test
)
```
