package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4) // + - * / & | ^ >> << >>>

  println(1 == x) // == !- >= <= < >

  println(!(1 == x)) // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /= ..... side effects!

  // Instructions (DO) vs Expressions (VALUE)


  // IF expression
  // in python, we say if this condition, then do this statement
  // in scala, if this condition, then express the value as this
  // its an expression and not an instruction of code!!
  // the if statement is an expression, so you can print it!
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition)5 else 3)

  // NEVER WRITE THIS AGAIN!
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING IN SCALA IS AN EXPRESSION
  // (except for definitions are not)

  val aWeirdValue = (aVariable = 3)  // Unit == void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning
  // side effects return units

  // Code blocks
  // value of the code block is the final line within the code block
  // can have there own variables within the code block
  // the scope of these variables is only visible within the code block

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" vs println("hello world")?
  // string is a value of type string
  // println(str) is of type unit (as it has a side effect of printing the string)

  //2.
  val someValue = {
    2 < 3
  }
  // true

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  // int

}
