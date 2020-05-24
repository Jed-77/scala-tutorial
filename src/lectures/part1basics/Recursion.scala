package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // Recursive Function
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I need factorial of " + (n-1))
      val result = n * factorial(n - 1) // not tail recursive
      println("Computed factorial of " + n)
      result
    }
  }
  // JVM uses a stack frame to 'store' the intermediate value from previous recursion
  // if i called factorial(5000) I would get a stack overflow
  // as the stack is storing all the intermediate values in the recursive call,
  // that we exhaust all available memory
  println(factorial(10))

  // In order to accumulate we use tail recursion
  // Use accumulators to store intermediate values instead of putting pressure on the stack

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // this checks if the function is tail recursive
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x-1, x*accumulator) // TAIL RECURSION - last expression is simply the function call
      // if the lastexpression was x * func (x-1) wouldn't be tail recursive
    }
    factorialHelper(n, 1)
  }
  //println(anotherFactorial(2000))

  // Practise Questions (tail recursion)
  // 1. Concatenate a string n times
  @tailrec
  def aStringConcatenate(x: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else aStringConcatenate(x, n-1, x + accumulator)
  }
  println(aStringConcatenate("Hello", 2 ,""))
  // aStringConcatenate("Hello", 1, "Hello")
  // aStringConcatenate("Hello", 0, "HelloHello")
  // "HelloHello"
  // effectively independent function calls, that do not require all to be evaluated (like usual recursion)
  // so the pressure on the stack is much less
  // @tailrec checks its tail recursive
  // return is simple a function call of aStringConcatenation
  // if return was "hello"+aStringConcatenate then wouldn't be tail recursive



  // 2. Is prime function
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t-1, n%t != 0 && isStillPrime)
    }
    isPrimeTailRec(n/2, true)
  }
  println(isPrime(2003))
  println(isPrime(629))




  // 3. Fibonacci function
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int ={
      if (i >= n) last
      else fiboTailRec(i+1, last+nextToLast, last)
    }
    if (n<=2) 1
    else fiboTailRec(2, 1, 1)
  }
  println(fibonacci(8))
}
