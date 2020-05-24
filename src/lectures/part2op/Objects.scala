package lectures.part2op

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("STATIC")
  // e.g. there are not static variables that can be access by a class (not the instance of a class)

  // SCALA HAS STATIC LIKE FUNCTIONALITY WHICH IS OBJECTS
  // can define val, var and objects inside of these
  // but you cant pass it parameters
  // scala object = SINGLETON instance (only 1 instance that can be referred to)
  // when you define the object, you define its type AND its only instance
  // so if mary and john are people, they equal each other!
  // in practise, we use objects and classes together (they are COMPANIONS)
  // to split "static" class level functionality of object (only instance)
  // and instance level functionality (many different instances) (as we can pass unique parameters)
  // this means we cover singleton class (object) and class for Person


  object Person {
    //"static" class-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method - as it builds persons
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }
  class Person (val name: String) {
    //instance-level functionality
  }

  // access 'static' methods
  println(Person.N_EYES)
  println(Person.canFly)

  // singleton class - true
  val mar = Person
  val joh = Person
  println(mar==joh)

  // as class is instance level functionality, they are not the same - false
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary==john)

  // factory methods
  // apply function in the object person to create a new person
  val bobbbie = Person.apply(mary, john)
  val bobbie = Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
