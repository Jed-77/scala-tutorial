package lectures.part3fp

object WhatIsAFunction extends App {

  // the whole point of functional programming is to use functions as first class elements
  // so a function can be passed as a parameter, returned from a function, and assigned to a variable
  // difficulty is that we come from OOP so everything is an instance of a class (how JVM is constructed)
  // JVM was created for OOP, so by using the Function1, Function2 etc classes and having every function an
  // ... instance of these classes allows us to do functional programming

  // this is an instance of the function like class (called MyFunction)
  // but because we used def apply you can call it using a () (similar to normal function call)
  // you can use function types (closer to functional programming)
  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element*2
  }
  println(doubler(2))

  //function types = Function1, Function2, ... , Function 22 (number is number of types required)
  val aStringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(aStringToIntConverter("3")+4)

  val adder: (Int, Int)=>Int = new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int): Int = a+b
  }

  // ALL SCALA FUNCTIONS ARE OBJECTS (INSTANCES OF CLASSES DERIVED FROM FUNCTION1, FUNCTION2, ..., FUNCTION22)

  //1. takes two strings and concatenates them
  val stringConcatenator: (String, String) => String = new Function2[String, String, String]{
    override def apply(a: String, b: String): String = a+b
  }
  println(stringConcatenator("Jed", ".Hello"))

  // 2. takes an int and returns a function which takes an int and returns an int
  // if you return a function, you can them use parenthsis on the return to run the function
  // or double brackets (in what we called a curried function)
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x+y
    }
  }
  val adder3 = superAdder(3) // this is a function! (that when called will add 3 to the parameter)
  println(adder3(4))         // 7
  println(superAdder(3)(4))  // 7 - CURRIED FUNCTION! (called with multiple parameters) as it returns a function!
}

trait MyFunction[A, B] {
  def apply(element: A): B //so you can call it with ()
}