Usage:

* Build the ClojureLibrary.java
* Put the resulting classes and clojure's jar in CLASSPATH
* Run JRuby and instantiate ClojureLibrary and call the load method, passing the JRuby runtime

You will now have a Clojure::Object class. Extending it will produce Ruby classes with all instance variables as Clojure Refs, so they work appropriately with dosync {} (also provided).
