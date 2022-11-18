// Code format plugins
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")

// Code style plugins
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "3.0.6")
addSbtPlugin("ch.epfl.scala"   % "sbt-scalafix"    % "0.10.3")

// Code codeverage plugins
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.0.1")

// Dependency check plugins
addSbtPlugin("net.vonbuchholtz" % "sbt-dependency-check" % "4.1.0")

// Packaging plugins
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.11")
addSbtPlugin("com.eed3si9n"   % "sbt-assembly"        % "1.2.0")

// Project documentation plugins
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox"                % "0.10.2")
addSbtPlugin("io.github.jonas"       % "sbt-paradox-material-theme" % "0.6.0")
