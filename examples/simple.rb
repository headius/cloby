require 'cloby'

class MyClojureObj < Clojure::Object
  def initialize
    dosync { @foo = 'foo' }
  end

  attr_accessor :foo
end

obj = MyClojureObj.new
puts "obj.foo = " + obj.foo

begin
  puts "Setting obj.foo to 'bar'"
  obj.foo = 'bar'
rescue ConcurrencyError
  puts "Oops, need a transaction"
end

puts "Trying again with a transaction"
dosync { obj.foo = 'bar' }
puts "Success"

puts "obj.foo = " + obj.foo
