package arrays

/**
  * Created by rajeevprasanna on 2/26/16.
  */

//http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
//Maximum sum such that no two elements are adjacent

// Question: Given an array of positive numbers, find the maximum sum of a sub sequence with the constraint that no 2 numbers in the sequence
// should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
// Answer the question in most efficient way.
object p4 extends App {

//  val l = List(5,  5, 10, 40, 50, 35) // ==> 80
//  val l = List(3, 2, 7, 10) // ==> 13
  val l = List(3, 2, 5, 10, 7) // ==> 15

  def maxAlternativeSum(l:List[Int]) = {
    def _maxSum(tracker:Int, beforePrevSum:Int, prevSum:Int):Int = tracker match {
      case _ if l == Nil || tracker >= l.length => prevSum
      case 0 => _maxSum(tracker+1, 0, beforePrevSum+l(0))
      case _  => val maxSum = prevSum.max(beforePrevSum)
                _maxSum(tracker+1, maxSum, beforePrevSum+l(tracker))
    }
    _maxSum(0,0,0)
  }

  val res = maxAlternativeSum(l)
  println(res)
}
