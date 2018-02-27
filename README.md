# Feature Test Sample

This is a sample project, where Intellij using `Use sbt shell for build and import` is enabled, run configuration for a test a class under [test folder](src/test) throws following exception

```
Unable to load a Suite class. This could be due to an error in your runpath. Missing class: com.github.rojanu.app.ExampleSpec
java.lang.ClassNotFoundException: com.github.rojanu.app.ExampleSpec
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:338)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at org.scalatest.tools.Runner$$anonfun$29.apply(Runner.scala:1213)
	at org.scalatest.tools.Runner$$anonfun$29.apply(Runner.scala:1211)
	at scala.collection.TraversableLike$$anonfun$filterImpl$1.apply(TraversableLike.scala:248)
	at scala.collection.immutable.List.foreach(List.scala:381)
	at scala.collection.TraversableLike$class.filterImpl(TraversableLike.scala:247)
	at scala.collection.TraversableLike$class.filter(TraversableLike.scala:259)
	at scala.collection.AbstractTraversable.filter(Traversable.scala:104)
	at org.scalatest.tools.Runner$.doRunRunRunDaDoRunRun(Runner.scala:1211)
	at org.scalatest.tools.Runner$$anonfun$runOptionallyWithPassFailReporter$2.apply(Runner.scala:1011)
	at org.scalatest.tools.Runner$$anonfun$runOptionallyWithPassFailReporter$2.apply(Runner.scala:1010)
	at org.scalatest.tools.Runner$.withClassLoaderAndDispatchReporter(Runner.scala:1500)
	at org.scalatest.tools.Runner$.runOptionallyWithPassFailReporter(Runner.scala:1010)
	at org.scalatest.tools.Runner$.run(Runner.scala:850)
	at org.scalatest.tools.Runner.run(Runner.scala)
	at org.jetbrains.plugins.scala.testingSupport.scalaTest.ScalaTestRunner.runScalaTest2(ScalaTestRunner.java:131)
	at org.jetbrains.plugins.scala.testingSupport.scalaTest.ScalaTestRunner.main(ScalaTestRunner.java:28)
```