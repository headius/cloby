require 'cloby'

ag = Agent.new 42

puts ag.deref # => 42

ag.dispatch 19 do |a,b|
  a-b
end

puts ag.deref # => 23

Agent.shutdown # IMPORTANT! program will not exit if agents are not shutdown