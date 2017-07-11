import scala.util.Try

name := "mustache"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.8.1" % "test->default",
  "org.specs2" %% "specs2" % "3.8.9" % "test->default"
)

excludeDependencies ++= Seq("org.specs2" %% "specs2-cats")

val snapshotRepository = Try("snapshots" at sys.env("REPOSITORY_SNAPSHOTS")).toOption
val releaseRepository =  Try("releases"  at sys.env("REPOSITORY_RELEASES" )).toOption

publishTo := {
  if (isSnapshot.value) {
    snapshotRepository
  } else {
    releaseRepository
  }
}
