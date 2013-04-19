import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "MyFistApp"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
//    "postgresql" % "postgresql" % "8.4-702.jdbc4",
    jdbc,
    anorm
  )

//libraryDependencies ++= Seq(
//  "org.reactivemongo" %% "reactivemongo" % "0.8"
//)
  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
