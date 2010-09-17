require 'android'

# Generated by Buildr 1.4.1, change to your liking
# Version number for this release
VERSION_NUMBER = "1.0.0"
# Group identifier for your projects
GROUP = "Debugoid"
COPYRIGHT = ""

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://www.ibiblio.org/maven2/"


ANDROID_TEST = ['com.google.android:android:jar:2.2.1']

desc "The Debugoid project"
define "Debugoid" do

  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT

  define "Debugoid" do
  end

  define "DebugoidTest" do
  end

end