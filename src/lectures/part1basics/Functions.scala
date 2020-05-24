package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)
  // don't necessarily need empty brackets

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS USE RECURSION INSTEAD OF LOOPS!

  // a function with side effects will return type unit
  // remember side effects do something other than evaluate
  // print a line, write a file, update a variable etc..
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)


  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }


  // TASKS
  // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  def aGreetingFunction(name: String, age: Int): Unit = {
    println("Hi, my name is " + name + " and I am " + age + " years old.")
  }
  aGreetingFunction("Jed", 24)

  // 2. Factorial function 1*2*3*4....*n
  def aFactorialFunction(n: Int): Int = {
    if (n <= 0) 1 else n*aFactorialFunction(n-1)
  }
  println(aFactorialFunction(5))

  // 3. A fibonnaci function f(1)=1, f(2)=1, f(n) = f(n-1) + f(n-2)
  def aFibonnaciFunction(n: Int): Int = {
    if (n <= 2) 1 else aFibonnaciFunction(n-1) + aFibonnaciFunction(n-2)
  }
  println(aFibonnaciFunction(8))

  // 4. Tests if a number is prime
  def aPrimeTestingFunction(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n / 2)
  }

}
