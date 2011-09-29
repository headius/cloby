require 'java'
require 'jruby'

begin
  Java::clojure.lang.Ref
rescue Exception
  require "mvn:org.clojure:clojure"
  begin
    Java::clojure.lang.Ref
  rescue Exception
    fail "Clojure is not available"
  end
end

# load ClojureLibrary
require 'cloby_ext.jar'
org.jruby.clojure.ClojureLibrary.new.load(JRuby.runtime, false)