package lectures.part2op

object CaseClasses extends App {

  // useful for
  case class Person(name: String, age: Int)

  // 1. class parameters are fields (without needing to write val in the constructor)
  val jim = Person("Jim", 34)
  println(jim.name)

  //2. sensible toString representation
  // if you println(instance) equiv to println(instance.toString) - syntactic sugar
  println(jim.toString)

  //3. equals and hashCode implemented OOTB (out of the box)
  val jim2 = Person("Jim", 34)
  println(jim == jim2) // if case class, these are true! if not then false as they are different instances

  //4. case classes have handy copy method
  val jim3 = jim.copy(age=45)
  println(jim3.name)
  println(jim3.age)

  //5. case classes have companion objects
  val thePerson = Person //Person is the companion object
  val mary = Person("Mary", 23) // so you can use the apply function and you don't need the new keyword when creating an instance

  //6. case classes are serializable
  // Akka framework

  //7. case classes ave extactor patterns
  // so case classes can be used in PATTERN MATCHING

  //you can have a case object
  // same functionality as case classes apart from you dont get companion object because they ARE object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }



}
