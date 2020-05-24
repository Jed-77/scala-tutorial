package lectures.part2op

object AbstractDataType extends App {

  // abstract
  // classes that contain blank/unimplemented members are abstract
  // basically provides a blueprint, as we will use subclasses to define the members (made to be extended later)
  // cannot create instance of an abstract class
  // in subclass use extend and then you overwrite member functions or variables (override keyword not required)
  // abstract classes can have both abstract and non-abstract members

  abstract class Animal{
    val creatureType: String
    def eat(): Unit
  }
  class Dog extends Animal {
    val creatureType: String = "canine"
    def eat(): Unit = println("crunchcrunch")
  }

  // traits
  // ultimate abstract data types
  // by definition traits have abstract fields and methods
  // unlike abstract classes they can be inherited along with classes!
  // so can create class that inherits from another class and from a trait
  // can have both abstract and non abstract members (i.e. you can give it a value)

  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    // all of these are overriding but don't need to explicitly include override keyword
    val creatureType: String = "croc" //override animal
    def eat(): Unit = println("nomnomnom")      //override animal
    def eat(animal: Animal): Unit = println(s"I am a croc and I'm eating ${animal.creatureType}")
    //override carnivore
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1. traits do not have constructor parameters, abstract parameters can have parameters
  // 2. you can only extend 1 class, but you can inherit multiple traits
  // 3. traits are behaviour (what things do), but abstract class is a thing (usually a blueprint for a thing)

}
