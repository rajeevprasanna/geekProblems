package arrays

/**
  * Created by rajeevprasanna on 2/28/16.
  */
object p13 extends App {

  //Merge sort in scala
  def mergeSort(xs:List[Int]):List[Int] = {
    val n = xs.length/2
    if(n==0) xs
    else {
      def merge(xs:List[Int], ys:List[Int]):List[Int] = (xs, ys) match {
        case (Nil , ys) => ys
        case (xs, Nil) => xs
        case (x::xs1, y::ys1) => if(x<y) x::merge(xs1, ys) else y::merge(xs, ys1)
      }
      val (left, right) = xs splitAt(n)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  val xs = List(7,4,2,5,1,3,8,6)
  mergeSort(xs).foreach(println)

  println("===========================================================================")

  val xs2 = Nil
  mergeSort(xs2).foreach(println)

  println("===========================================================================")

  val xs3 = List(2)
  mergeSort(xs3).foreach(println)

}