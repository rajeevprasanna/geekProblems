package arrays

/**
  * Created by rajeevprasanna on 2/26/16.
  */
//http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

//Given an array arr[], find the maximum j – i such that arr[j] > arr[i]

object p6 extends App {

//  val l = List(34, 8, 10, 3, 2, 80, 30, 33, 1)
//  val l = List(9, 2, 3, 4, 5, 6, 7, 8, 18, 0)
//  val l = List(1, 2, 3, 4, 5, 6)
  val l = List(6, 5, 4, 3, 2, 1)
  val lesser = l.zipWithIndex.map(x => (l.zipWithIndex.take(x._2).find(_._1 < x._1)))
  val greater = l.zipWithIndex.reverse.map(x => l.zipWithIndex.reverse.dropRight(x._2).find(_._1 > x._1))

  val res = lesser.zip(greater).foldLeft(-1, (1, 1)) { (l, r) =>
    r match {
      case (Some(x), Some(y)) if y._1 > x._1 => val diff = (y._2 - x._2)
        if(diff > l._1) (diff, (x._2, y._2)) else l
      case  _ => l
    }
  }._1

  println(res)
}
