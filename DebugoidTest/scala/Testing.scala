package novoda.debugoid

import _root_.junit.framework.Assert._
import _root_.android.test.ActivityInstrumentationTestCase2
import _root_.android.app.ListActivity

class Testing(pkg: String, klass: java.lang.Class[DebugPreferenceList]) extends ActivityInstrumentationTestCase2[DebugPreferenceList](pkg, klass) {

    def setup {
       runTest()
    }
    
  def testPackageIsCorrect {
      assertTrue(true)
  }

  def testPackageIsCool {
  }

  override def $tag(): Int = {
    try {
      return super.$tag();
    } catch {
      case e: Exception => throw new RuntimeException(e);
    }
  }

}
