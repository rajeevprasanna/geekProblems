package arrays

/**
  * Created by rajeevprasanna on 2/26/16.
  */


//http://www.geeksforgeeks.org/leaders-in-an-array/
//  Leaders in an array
//  Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
// And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

object p5 extends App {

  val l = List(16, 17, 4, 3, 5, 2)

  l.reverse.foldLeft(0, List[Int]()){ (left, x) =>
      if(x > left._1)
        (x, x::left._2)
       else
        left
  }._2.foreach(println)

}
