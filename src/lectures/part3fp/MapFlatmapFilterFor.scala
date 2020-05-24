package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)  // standard library
  println(list.head)
  println(list.tail)

  //map - run the function for each parameter of the list
  println(list.map(_+1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_  % 2 ==0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // 1. print all combination
}
