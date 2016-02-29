package arrays

/**
  * Created by rajeevprasanna on 2/28/16.
  */

//Quick sort
object p12 extends App {

  //Choose pivot randomly in the list and rearrange list
  import scala.util.Random.nextInt
  def choosePivot(xs:List[Int]):Int =  if(xs.isEmpty) 0 else xs(nextInt(xs.length))

  def quickSort(xs:List[Int]):List[Int] = {
    def _quickSort(xs:List[Int], p:Int):List[Int] = {
      if(xs.isEmpty || xs.length == 1) xs
      else {
        val ys:(List[Int], List[Int]) = xs.partition(_ < p)
        _quickSort(ys._1, choosePivot(ys._1)):::_quickSort(ys._2, choosePivot(ys._2))
      }
    }
    _quickSort(xs, choosePivot(xs))
  }

  val xs = List(7,4,2,5,1,3,8,6)
  quickSort(xs).foreach(println)

  println("===========================================================================")

  val xs2 = Nil
  quickSort(xs2).foreach(println)

  println("===========================================================================")

  val xs3 = List(2)
  quickSort(xs3).foreach(println)
}