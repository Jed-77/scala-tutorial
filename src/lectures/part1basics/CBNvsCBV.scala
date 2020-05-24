package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    // want long as we want nano seconds (since 1970)
    // returns unit as the return is actually a side effect
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    // => tells the compiler  that the parameter will be called by name
    println("by name: " + x)
    println("by name: " + x)
  }

  // Value, it evaluates the value of parameter and passes the value through the function
  calledByValue(System.nanoTime())
  // Name, it passes the actual name value through, so delays the evaluation until its used within the function
  calledByName(System.nanoTime())


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)
  //printFirst(infinite(), 34) // this is a stack overflow as it evaluates infinite() which is stupid
  printFirst(34, infinite())
  // this works fine as the pass by name delays evaluation until inside function (not when parameter passed)
  // if you made the parameter in printFirst y: Int, it would break as it would try to evaluate infinite()

}
