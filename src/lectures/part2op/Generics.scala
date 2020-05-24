package lectures.part2op

object Generics extends App {

  // generic class as we can pass any type 'A'
  // you can create generic trait too
  // objects cannot be type parameterised
  class MyList[A] {
    // use the type A inside (A is type)
    // similar to templates in C++
  }
  // multiple types
  class MyMap[Key, Value]{
  }
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  // this would also work for traits

  // generic methods

  // companion to class above
  // function takes a type A and returns a MyList with type A
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]


  // variance problem
    // Q: if cat extends animal, does a list of cats extend a list of animals?
  class Animal
  class Cat extends Animal
  class Dog extends Animal

    // A1: YES -> COVARIANCE
  class CovariantList[+A] // covariant list has +A in the type parameter
  // this allows the list of animals to be equal to a list of cats
  val animal: Animal = new Cat //single value
  val animalLst: CovariantList[Animal] = new CovariantList[Cat] // for a list
  // polymorphism!!
  // what happens if we animalList.add(new Dog)? we have list of animals of type cat so HARD QUESTION
  // we will turn the list of cats INTO a list of animals!
  // the way you do this is the following code
  // >>> class MyList[+A] {
  //            def add[B >: A](element: B): MyList[B] = ???
  //        }
  // what are saying is we have a list of cats (A) and have covariance. If we add an animal to the list (B)
  // ... as the B is a super class of A (animals is super of cat) we will return a list of animals!
  // ... so adding a dog to a list of cats returns a list of animals!!!!!


    // A2: NO -> INVARIANCE
  // effectively a list of cats and list of animals are two seperate things
  // so a list of animals cannot be a list of cats (animal to animal or cat to cat)
  // every type is in its own world
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] // if this was cat then 0

    // A3: HELL NO! -> CONTRAVARIANCE
  // opposite of covariance
  // a list of cats can be given an animal (or cats)
  // if we were thinking of trainer's here it would work. A trainer of animals would indeed be able to
  // ... train a cat. So a list of cat trainers could be a list of animal trainers.
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]


  // bounded types
  // allow to use generic class only for certain types that are super classes or sub class of certain type
  // here cage only accepts types which are animal, or sub-types of animal (e.g. cat)
  class Cage[A <: Animal](animal: A) // upper bounded type
  val cage = new Cage(new Dog)
  // lower bounded would be Cage[A >: Animal] so only accepts types which are super class of animal




}
