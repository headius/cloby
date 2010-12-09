# -*- encoding: utf-8 -*-

Gem::Specification.new do |s|
  s.name = %q{cloby}
  s.version = "0.0.1"
  s.authors = ["Charles Oliver Nutter"]
  s.date = Time.now.strftime('YYYY-MM-DD')
  s.description = "Clojure-based transactional semantics for Ruby instance variables"
  s.email = ["headius@headius.com"]
  s.files = Dir['{lib,examples,test}/**/*'] + Dir['{*.txt,*.gemspec,Rakefile}']
  s.homepage = "http://github.com/headius/cloby"
  s.require_paths = ["lib"]
  s.summary = "Clojure-based transactional semantics for Ruby instance variables"
  s.test_files = Dir["spec/*_spec.rb"]
  s.platform = "java"
end
