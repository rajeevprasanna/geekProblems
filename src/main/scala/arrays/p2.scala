package arrays

/**
  * Created by rajeevprasanna on 2/26/16.
  */
//Majority Element
//  Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).
//  http://www.geeksforgeeks.org/majority-element/
object p2 extends App {
  val l = List(1, 1, 1, 1, 1, 2, 3, 4)
  val res = l.groupBy(x => x).toSeq.sortBy(_._2.length).last._1
  println(res)
}
