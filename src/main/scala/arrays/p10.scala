package arrays

/**
  * Created by rajeevprasanna on 2/27/16.
  */

//http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
//Maximum difference between two elements such that larger element appears after the smaller number

object p10 extends App {

  val MIN = -84673843
  val MAX = 84673843
  //  val list = List(2, 3, 10, 6, 4, 8, 1)
  val list = List( 7, 9, 5, 6, 3, 2)

  def lesser(x:Int, y:Int):Boolean = x<y
  def greater(x:Int, y:Int):Boolean = x>y
  def formatList(l:List[Int], t:Int, fn:(Int, Int) => Boolean):List[Int] =  l.foldLeft((t, List[Int]())){(le, x) => if(fn(x, le._1)) (x, le._2:::List(x)) else (le._1, le._2:::List(le._1))}._2

  val left = formatList(list, MAX, lesser)
  val right = formatList(list.reverse, MIN, greater)

  val res = left.zip(right.reverse).foldLeft(MIN, (0,0)){ (res, x) =>
    val diff = x._2 - x._1
    if(diff > res._1) (diff, x) else res
  }._2

  println(res)
}
