import scala.util.Try

name := "mustache"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.8.1" % "test->default",
  "org.specs2" %% "specs2" % "2.3.12" % "test->default"
)

val snapshotRepository = Try("snapshots" at sys.env("REPOSITORY_SNAPSHOTS")).toOption
val releaseRepository =  Try("releases"  at sys.env("REPOSITORY_RELEASES" )).toOption

publishTo := {
  if (isSnapshot.value) {
    snapshotRepository
  } else {
    releaseRepository
  }
}
