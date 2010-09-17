import sbt._
import de.element34.sbteclipsify._

trait Defaults {
  def androidPlatformName = "android-8"
}

class HelloWorldProject(info: ProjectInfo) extends DefaultProject(info)
{
  lazy val main  = project("Debugoid", "Debugoid main application", new MainProject(_))
  lazy val tests  = project("DebugoidTest", "Debugoid android test application", new TestProject(_), main)
  class MainProject(info: ProjectInfo) extends AndroidProject(info) with Defaults with Eclipsify {
    override def sourcePath = path(".")
    override def mainSourcePath = path(".")
    override def outputPath = path("bin")
   }
class TestProject(info: ProjectInfo) extends AndroidTestProject(info)
                                         with Defaults with Eclipsify {
    override def sourcePath = path(".")
    override def mainSourcePath = path(".")
    override def outputPath = path("bin")
                                             
 }
}

