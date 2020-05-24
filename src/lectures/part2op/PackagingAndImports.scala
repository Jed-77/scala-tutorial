package lectures.part2op
import playground.{Cinderella => Princess, PrinceCharming}


// the package means that whatever we write within this file, will be part of (this package)
// ... the lectures.part2op package

// import the package to get access to it

// if you are importing multiple classes/objects from another package, you use {} notation
// e.g. import playground.{Cinderella, PrinceCharming}
// you can use import playground._ to get everything
// you can create alias using the =>



object PackagingAndImports extends App {

  // package members are accessible by their simple name
  // so I can access anything within the lectures.part2op package

  // if you want something from outside the current package, you need to import the package
  val princess = new Princess
  // you can also use the fully qualified name, so val princess = new playground.Cinderella

  // packages are ordered in hierarchy.
  // e.g. lectures.part2oop from the top, part2oop is a subpackage of the lectures
  // this maps the folder structure in the file system!
  // so within src, we have excercises, lectures, playgrounds
  // then we have sub packages of these packages (which can be linked using . notation)
  // so import playground.Cinderella etc...


  // package object
  // used when you want to create global method/constants outside of classes, objects traits etc
  // universal constants and methods!
  // you only get 1 per package (created using the package object, and gets the name of the package)
  // at the top you'll see the package it is also visible too
  // you can access the package object in the package as they are visible
  println(SPEED_OF_LIGHT)


  // imports
  val prince = new PrinceCharming

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???



}
