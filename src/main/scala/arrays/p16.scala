package arrays

/**
  * Created by rajeevprasanna on 2/28/16.
  */
//http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

//Kadane's algorithm

//Largest Sum Contiguous Subarray
//Write an efficient C program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.


object p16 extends App {

  val l = List(-2, -3, 4, -1, -2, 1, 5, -3)

  def getMaxSum(l:List[Int]):Int = {
    def _getMaxSum(l:List[Int], curSum:Int, maxSum:Int):Int = l match {
      case Nil => maxSum
      case h::tail if h+curSum < 0 => _getMaxSum(tail, 0, maxSum)
      case h::tail if h+curSum > maxSum => _getMaxSum(tail, h+curSum, h+curSum)
      case h::tail => _getMaxSum(tail, h+curSum, maxSum)
    }
    _getMaxSum(l, 0, 0)
  }

  val res = getMaxSum(l)
  println(res)
}
