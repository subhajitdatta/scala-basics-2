name := "scala-basics-2"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
    "org.mockito" % "mockito-core" % "1.9.5" % "test",
    "org.specs2" %% "specs2" % "2.3.10" % "test"
)

transitiveClassifiers in Global := Seq(Artifact.SourceClassifier)

org.scalastyle.sbt.ScalastylePlugin.Settings
