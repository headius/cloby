require 'java'
require 'jruby'

begin
  Java::clojure.lang.Ref
rescue Exception
  $stderr.puts "Clojure is not available, load it first"
  raise
end

# load ClojureLibrary
require 'cloby_ext.jar'
org.jruby.clojure.ClojureLibrary.new.load(JRuby.runtime, false)