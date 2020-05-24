package lectures.part2op

object Exceptions extends App {

  val x: String = null
  // println(x.length) >>> this will crash the JVM with NullPointerException

  // throwing and catching exceptions
  // these are all jvm specific

  //1. throwing
  // throws exception, intentionally crashing code
  // its an expression so can be given to a value
  // by default it returns nothing, as exceptions(and errors) are classes!
  // so new instantiates a new class of NullPointerException
  // throwable classes extend the throwable class
  // we have throwable classes of Exceptions and Errors (both extend throwable)
  // Exceptions are used for problems with the program (e.g. NullPointerException)
  // Errors are used for problems with the system(e.g. StackOverFlowError)
  //val aWeirdValue: Exception = throw new NullPointerException

  //2. catching exceptions
  def getInt(withExceptions: Boolean): Unit = {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42
  }

  // as the try,catch,case,finally code is an expression, you can make it a variable
  // the type is the type returned from the try block, and all cases in the catch block
  // not impacted by finally
  // if these datatypes are different we can use : AnyVal
  val potentialFail: AnyVal = try {
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a run time exception")
  } finally {
    //code that will get executed no matter what! (even if there is an error not caught before!)
    // finally block is optional
    // doesn't influence the return type of expression
    // use finally only for side effects (e.g. logging something to a file)
    println("finally")


    // 3. how to define your own exceptions
    // classes that extend from exception or error
    // or extend it from an already extended class of exception (e.g. RuntimeException)
    // then you can throw it!

    class MyException extends RuntimeException
    val exception = new MyException
    throw exception

    // examples

  }





}
