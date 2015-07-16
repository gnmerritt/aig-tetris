name := "aig-tetris"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.beachape" %% "enumeratum" % "1.2.2",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

ScoverageSbtPlugin.ScoverageKeys.coverageHighlighting := {
  if (scalaBinaryVersion.value == "2.11") true
  else false
}

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
