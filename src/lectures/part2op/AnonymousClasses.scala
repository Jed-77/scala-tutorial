package lectures.part2op

object AnonymousClasses extends App {

  abstract class Animal{
    def eat: Unit
  }

  // anonymous class
  // supply implementation of class when the instance is created
  // the compiler will create an anonymous class which extents animal which has an override eat method
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahah")
  }
}
