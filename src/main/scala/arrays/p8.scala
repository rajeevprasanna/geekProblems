package arrays

/**
  * Created by rajeevprasanna on 2/27/16.
  */
//http://www.geeksforgeeks.org/find-subarray-with-given-sum/

//Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
//
//Examples:
//
//Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
//Ouptut: Sum found between indexes 2 and 4
//
//Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
//Ouptut: Sum found between indexes 1 and 4
//
//Input: arr[] = {1, 4}, sum = 0
//Output: No subarray found

object p8 extends App {

  val l = List(1, 4, 20, 3, 10, 5)
  val sum = 33

//  val l = List(1, 4, 0, 0, 3, 10, 5)
//  val sum = 7

//  val l = List(1,4)
//  val sum = 0

  def getSubArray(list: List[Int], sum: Int): (Int, Int) = {
    def _getSubArray(l: List[Int], curSum: Int, startIndex:Int, endIndex:Int): (Int, Int) = l match {
      case Nil => (startIndex, endIndex)
      case _ if sum == 0 || sum == curSum => (startIndex, endIndex)
      case h :: tail if h + curSum == sum =>  (startIndex, endIndex+1)
      case h :: tail => if (h + curSum < sum) {
        _getSubArray(l.tail, curSum + h, startIndex, endIndex+1)
      } else {
        _getSubArray(l, curSum - list(startIndex), startIndex+1, endIndex)
      }
    }
    _getSubArray(list, 0, 0, -1)
  }
  val res = getSubArray(l, sum)

  if(res._2 == -1){
    println("No subarray found")
  }else{
    println(res)
  }
}
