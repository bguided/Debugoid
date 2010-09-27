import sbt._
class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val android = "org.scala-tools.sbt" % "sbt-android-plugin" % "0.5.0"
  val eclipsify = "de.element34" % "sbt-eclipsify" % "0.6.0"
  val scalatest = "org.scalatest" % "scalatest" % "1.0" % "test->default"
}
