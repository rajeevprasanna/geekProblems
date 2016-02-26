package arrays

/**
  * Created by rajeevprasanna on 2/26/16.
  */
//http://www.geeksforgeeks.org/array-rotation/
//Program for array rotation
//Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.

object p3 extends App {

  val l = List(1, 2, 3, 4, 5, 6, 7)
  val d = 2
  val n = 7

  val res = l.drop(d):::l.take(d)
  res.foreach(println)
}
