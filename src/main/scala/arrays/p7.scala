package arrays

/**
  * Created by rajeevprasanna on 2/26/16.
  */
//http://www.geeksforgeeks.org/maximum-length-bitonic-subarray/

//Maximum Length Bitonic Subarray
//Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic if there is a k with i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j]. Write a function that takes an array as argument and returns the length of the maximum length bitonic subarray.
//Expected time complexity of the solution is O(n)
//
//Simple Examples
//1) A[] = {12, 4, 78, 90, 45, 23}, the maximum length bitonic subarray is {4, 78, 90, 45, 23} which is of length 5.
//
//2) A[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.
//
//Extreme Examples
//1) A[] = {10}, the single element is bitnoic, so output is 1.
//
//2) A[] = {10, 20, 30, 40}, the complete array itself is bitonic, so output is 4.
//
//3) A[] = {40, 30, 20, 10}, the complete array itself is bitonic, so output is 4.
//

object p7 extends App {

  val l = List(12, 4, 78, 90, 45, 23)
//  val l = List(20, 4, 1, 2, 3, 4, 2, 10)
//  val l = List(10)
//  val l = List(10, 20, 30, 40)
//  val l = List(40, 30, 20, 10)

  //For every element, find left side subsequent element count less than current element
  //For every element, find right side subsequent element count greater than current element


  def getSubList(l:List[Int], fn:(Int, Int) => Boolean):List[Int] = {
    def _getSubList(subList:List[Int], res:List[Int]):List[Int]  = subList match {
      case h::tail if(fn(h, res.head)) => _getSubList(tail, h::res)
      case _ =>  res
    }

    if(l.length <= 1) l
    else _getSubList(l.tail, List(l.head))
  }

  def lesserEleSeqOfIndexes(l:List[Int]) = {
    val listComponents = l.zipWithIndex.map(x => l.take(x._2+1).reverse)
    listComponents.map(e => getSubList(e,  (x,y) => x < y)).map(x => x.length-1)
  }

  def greaterEleSeqOfIndexes(l:List[Int]) = {
    val listComponents = l.zipWithIndex.map(x => l.drop(x._2))
    listComponents.map(e => getSubList(e,  (x,y) => x < y).reverse).map(x => x.length-1)
  }


  val lesserSeq = lesserEleSeqOfIndexes(l)
  val greaterSeq = greaterEleSeqOfIndexes(l)

  val res = lesserSeq.zip(greaterSeq).map(x => x._1 + 1 +  x._2 ).max

  println(res)
}
