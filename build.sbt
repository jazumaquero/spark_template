import Dependencies._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.zcia"
ThisBuild / organizationName := "example"

ThisBuild / assemblyMergeStrategy := {
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}

Compile / compile / wartremoverErrors ++= Warts.allBut(Wart.ScalaApp)

Compile / paradoxMaterialTheme := {
  ParadoxMaterialTheme()
    .withColor("red", "orange")
    .withLogoIcon("cloud")
    .withCopyright("Copyleft © Jonas Fonseca")
}

lazy val root = (project in file("."))
  .enablePlugins(ParadoxPlugin)
  .enablePlugins(ParadoxMaterialThemePlugin)
  .settings(
    name                       := "Template project",
    assembly / mainClass       := Some("com.zcia.Hello"),
    assembly / assemblyJarName := "hello.jar",
    coverageEnabled            := true,
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaLogging,
      logbackClassic,
      spark % "provided"
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
