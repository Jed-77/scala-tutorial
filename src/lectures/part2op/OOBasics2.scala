package lectures.part2op

object OOBasics extends App {

  //val person = new Person("John", 26)
  //println(person.x)
  //person.greet("Daniel")

  val writer = new Writer("Jed", "Scanlon", 25)
  println(writer.fullName)

  val novel = new Novel("My Book", 2000, writer)
  println(novel.author.fullName)
  println(novel.yearOfRelease)
  println(novel.isWrittenBy(writer))

  val novel2 = novel.copy(2014)
  println(novel2.author.fullName)
  println(novel2.yearOfRelease)


}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2
  println(1+3)

  // method
  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }

  // overloading (this is implied)
  // can overload same function with different number of paramaters, types, return types etc
  def greet(): Unit = println(s"Hi, I am $name")

  // overloading constructors
  def this(name: String) = this(name, 0)
}

// 1.
// Novel and a Writer
// Writer: first name, surname, year
//    - method full name

// Novel: name, year of release, author
//    - method authorAge
//    - isWrittenBy(author)
//    - copy (newYearRelease) = new instance of novel

class Writer (val firstName: String, val lastName: String, val age: Int){
  // value
  val fullName = s"${this.firstName} ${this.lastName}"
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer){
  // values
  val authorAge: Int = author.age
  // method
  def isWrittenBy(authorToCompare: Writer): Boolean = {
    if (authorToCompare.firstName == this.author.firstName) true
    else false
  }
  def copy(newYearRelease: Int): Novel = {
    new Novel(this.name, newYearRelease, this.author)
  }
}



// 2.
// Counter class
//     Receives an int value
//     Method current count
//     Method to increment/decrement => New Counter
//     overload inc/dec to recieve an amount

class Counter(val count: Int){
  def inc = new Counter(count+1) //immutability

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }


}
