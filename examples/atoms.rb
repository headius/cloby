require 'cloby'

atom = Atom.new 5

atom.swap{|a| a + 6}
puts atom.deref # => 11

puts atom.compare_and_set(42, 11) # => false
puts atom.deref # => 11

puts atom.compare_and_set(11, 42) # => true
puts atom.deref # => 42

puts atom.swap(1,2,3) {|a,b,c,d| a+b+c+d} # => 48

atom.reset 13

puts atom.deref # => 13