package lectures.part2op

object MethodNotations extends App {

  class Person (val name: String, val favouriteMovie: String, val age: Int){
    def likes(movie: String): Boolean = movie == this.favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    //infix notation
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    //prefix notation
    def unary_! : String = s"$name, what the heck?!"
    //postfix notation
    def isAlive: Boolean = true
    // apply method
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"

    //1.
    def +(nickName: String): Person = new Person(s"${this.name} ($nickName)", this.favouriteMovie, this.age)

    //2.
    def +(ageToAdd: Int): Person = new Person(this.name, this.favouriteMovie, this.age+ageToAdd)

    //4.
    def apply(n: Int): String = s"${this.name} watched ${this.favouriteMovie} $n times"

  }

  val mary = new Person("Mary", "Inception", 25)
  println(mary.likes("Inception"))
  println(mary likes "Inception") //infix notation (operator notation) (syntactic sugar)
  // use it for single paramter function

  // "operators" - actually methods!
  // SYNTACTIC SUGAR

  //1. INFIX NOTATION (I.E. X + Y (OR X.+(Y))
  val tom = new Person("Tom", "FightClub", 25)
  println(mary hangOutWith tom)  // function with one parameter acts like an operator
  println(mary + tom)  // acts like an operator (we have overridden + operator for method)
  println(mary.+(tom))

  // ALL OPERATORS ARE METHODS
  println(1+2)
  println(1.+(2)) // we access the + method from 1 (instance of integer class I guess?)

  // 2. PREFIX NOTATION E.G. -X, OR !X
  // UNARY OPERATORS ARE ALSO METHODS
  val x = -1
  val y = 1.unary_- // these are the same thing!
  // unary_prefix works with - + ! ~ (using synatx of unary_!, unary_-, unary_+, unary_~)

  // use the unary operator on our class (we have enable us to use operator on it)
  println(!mary) //these are the same thing!
  println(mary.unary_!)

  // 3. POSTFIX NOTATION (rarely used)
  // only available to methods without parameters


  // 4.  APPLY METHOD NAME (is a special function)
  println(mary.apply())
  println(mary()) // equivalent (if empty brackets, it will look for apply function



  //1.
  val mary1 = mary + "The Rockstar"
  println(mary1.name)
  println(mary1.favouriteMovie)

  //2.
  val mary2 = mary + 2
  println(mary2.name)
  println(mary2.age)

  //3.
  println(mary(2))
  println(mary.apply(2))

  /*
    1. Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)", same film

    2. add an age to the person class
        add a unary + operator which will add the age +1 and a return a new person

    3. add a "learns" method in the person class
        pass a string and returns "mary learns scala"
        add a learnScala method, calls the earns method
        use it in post fix notation

    4. add another apply method (overload it) to recieve it
      mary.apply(2) => "mary watched Inception 2 time"
   */


}
