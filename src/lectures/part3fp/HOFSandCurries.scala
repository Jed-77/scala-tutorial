package lectures.part3fp

import scala.annotation.tailrec

object HOFSandCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // any function that takes function as parameter or returns a function is called a higher order function (HOF)

  // define a function that applies a function n times over a value x
  // nTimes(f, n, x)
  // f is the function
  // n is number of times
  // x is the value
  // nTimes(f,3,x) = f(f(f(x))) --> HOF!
  // for recursion, not nTimes(f,3,x) = nTimes(f,2,f(x)) as f(f(f(x))) = f(f([f(x)]))
  // remember when passing a function use (Type1, Type2) => Type3
  @tailrec
  def nTimes(f: Int=> Int, n:Int, x:Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x+1
  println(nTimes(plusOne, 10, 1))

  // ntb(f,n)= x => f(f(f(...(f(x))))
  // instead of returning the value we return the lambda
  def nTimesBetter(f: Int=>Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))
  println(nTimesBetter(plusOne, 10)(1))
}
