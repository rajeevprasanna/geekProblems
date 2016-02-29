package arrays

/**
  * Created by rajeevprasanna on 2/18/16.
  */
//http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
//Given an array A[] and a number x, check for pair in A[] with sum as x

object p1 extends App {

  val l = List(1, 4, 45, 6, 10, -8)
  val s = l.toSet
  val sum = 16
  val res = l.filter(x => s.contains(sum-x)).mkString(", ")
  println(res)
}
