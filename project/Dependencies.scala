import sbt._

object Dependencies {
  lazy val scalaTest      = "org.scalatest"              %% "scalatest"       % "3.2.11"
  lazy val scalaLogging   = "com.typesafe.scala-logging" %% "scala-logging"   % "3.9.4"
  lazy val logbackClassic = "ch.qos.logback"              % "logback-classic" % "1.2.10"
  lazy val sparkVersion   = "3.2.0"
  lazy val spark          = "org.apache.spark"           %% "spark-core"      % sparkVersion
  lazy val sparkSQL       = "org.apache.spark"           %% "spark-sql"       % sparkVersion
}
