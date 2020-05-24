package exercises

abstract class MyList {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = if this list empty
    add(int) => new list with this element added
    overwrite toString => a string representation of the list
   */
  // create signatures for the members
  def head(): Int
  def tail(): MyList
  def isEmpty: Boolean
  def add(n: Int): MyList
  def printElements: String
  override def toString: String = "["+printElements+"]"
  //override def toString: String
}

object Empty extends MyList {
  def head(): Int = throw new NoSuchElementException
  def tail(): MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(n: Int): MyList = new Cons(n, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head(): Int = h
  def tail(): MyList = t
  def isEmpty: Boolean = false
  def add(n: Int): MyList = new Cons (n, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + "" + t.printElements
  }
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons (3, Empty)))
  println(list.head)
  println(list.add(4).head)
  println(list.toString)
}