package arrays

/**
  * Created by rajeevprasanna on 2/29/16.
  */

//http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/

//Maximum circular sub array sum
//Given n numbers (both +ve and -ve), arranged in a circle, find the maximum sum of consecutive numbers.
//
//Examples:
//
//Input: a[] = {8, -8, 9, -9, 10, -11, 12}
//Output: 22 (12 + 8 - 8 + 9 - 9 + 10)
//
//Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1}
//Output:  23 (7 + 6 + 5 - 4 -1 + 10)
//
//Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
//Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)

object p17 extends App{

  //Algo : Find the total sum and remove the minimum sum to get max circular subarray sum

  def getMaxSum(l:List[Int]):Int = {
    def _getMaxSum(l:List[Int], curSum:Int, maxSum:Int):Int = l match {
      case Nil => maxSum
      case h::tail if h+curSum < 0 => _getMaxSum(tail, 0, maxSum)
      case h::tail if h+curSum > maxSum => _getMaxSum(tail, h+curSum, h+curSum)
      case h::tail => _getMaxSum(tail, h+curSum, maxSum)
    }
    _getMaxSum(l, 0, 0)
  }

  val l = List(11, 10, -20, 5, -3, -5, 8, -13, 10)
  val totalSum = l.reduce(_+_)

  //Invert sign of each element and find max value in that
  val inverted = l.map(_ * -1)
  val maxInvertedSum = getMaxSum(inverted)

  val wrappedSum = totalSum + maxInvertedSum
  val kadaneSum = getMaxSum(l)

  val resultantSum = if(wrappedSum > kadaneSum)  wrappedSum else kadaneSum
  println(s"Max circular subarray sum => ${resultantSum}")
}
