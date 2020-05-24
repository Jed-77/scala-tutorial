package lectures.part2op

object Inheritance extends App {

  // single class inheritance

  // cat is subclass, animal is super class
  // subclass inherits non private members of super class
  // so if private def in super class cannot work
  // protected can only be accessed by the super-class or the sub-class, but not outside
  // private, protected (nothing = public)

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }
  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("crunchcrunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  // JVM rule is constructor of parent (super) class is called FIRST!
  // so you need to make sure it will create the parent class successfully
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  // all instances of dog would use eat defined in dog class
  class Dog(dogType: String) extends Animal {
    override val creatureType: String = this.dogType
    override def eat = {
      super.eat
      println("crunchcrunch")
    }
  }
  val dog = new Dog("K9")
  println(dog.eat)
  println(dog.creatureType)

  // type substitution (polymorphism)
  // method call will go to the most overridden version
  // imagine you have loads of different animals (each with an overriden noise they make)
  // if you keep making new animals (of type animal!) and call their noise, it'll be the overridden noise
  // so the cow goes moo, even though its type animal!
  // we can create a new animal but pass a dog as a type!
  // as dog inherits from animal, we can create a new animal using dog
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat //outputs the overridden function eat from the dog class, not the animal class!

  // overRIDING vs overLOADING
  // RIDING -> supply different implementation in sub classes (think inheritance)
    // e.g. override the function eat() in animal subclasses
  // LOADING -> multiple methods with different signatures in same class (think operator)
    // e.g. overloading the + operator in a complex number class


  // super
  // used in the subclass to access methods from the parent (super) class

  // preventing overrides
  // 1. - use the keyword final on a member function/variable
    // (e.g. final def eat(): {}) as you cannot override a final member
  // 2. - use the keyword final on the class itself
    // (e.g. final class Animal) - cannot override anything from a final class
    // numerical and string classes in scala are final
  // 3. - seal the class - you can extend in THIS FILE, but prevents extension in another class
    // used when you want to create an exhaustive types so you can't extend any more.



}
