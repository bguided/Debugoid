require 'rubygems'
require 'buildr'

module Android
  include Extension
  
  first_time do
    desc 'Count lines of code in current project'
    raise "ANDROID_SDK or ANDROID_HOME variable needs to point to your android installation" unless ENV['ANDROID_SDK'] || ENV['ANDROID_HOME']
    sdk = ENV['ANDROID_SDK'] || ENV['ANDROID_HOME']
    
    Project.local_task('loc')    
  end

  before_define do |project|
    # Define the loc task for this particular project.
    Rake::Task.define_task 'loc' do |task|
      lines = task.prerequisites.map { |path| Dir['#{path}/**/*'] }.flatten.uniq.inject(0) { |total, file| total + File.readlines(file).count }
      puts "Project #{project.name} has #{lines} lines of code"
    end
  end

  after_define do |project|
    # Now that we know all the source directories, add them.
    task('loc'=>project.compile.sources + project.test.sources)
  end

  # To use this method in your project:
  #   loc path_1, path_2
  def loc(*paths)
    task('loc'=>paths)
  end

end

class Buildr::Project
  include Android
end
