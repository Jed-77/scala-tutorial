package lectures.part3fp

object AnonymousFunctions extends App {

  // OOP way to create function value
  val doublerOld = new Function1[Int, Int] {
    override def apply(x: Int): Int = x*2
  }

  // Cleaner way (sytactic sugar) equivalent to above
  // anonymous function (LAMBDA)
  val doublerNew: Int => Int = x => x*2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  val niceAdder: (Int, Int) => Int = _ + _

  // no params - must be called using the parenthesis
  val justDoSomething = () => 3

  // curly braces with lambdas (this style is used sometimes)
  val stringToInt = { str: String =>
    str.toInt
  }

  // MORE syntactis sugar (these are equivalent)
  val plainIncrementer: Int => Int = (x: Int) => x+1
  val niceIncrementer: Int => Int = _ + 1




}
