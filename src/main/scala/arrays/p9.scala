package arrays

/**
  * Created by rajeevprasanna on 2/27/16.
  */
//http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
//Replace every element with the greatest element on right side
//Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array.
// Since there is no element next to the last element, replace it with -1.
// For example, if the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.

object p9 extends App {

  val l = List(16, 17, 4, 3, 5, 2)
  val MIN = -1

  def getGreatestElement(l:List[Int]):List[Int] = l match {
    case Nil => l
    case List(h) => List(-1)
    case _ => l.tail.foldRight(List(-1), MIN){(right, left) =>
      if(right > left._2) (right::left._1, right) else (left._2::left._1, left._2)
    }._1
  }
  val res = getGreatestElement(l)
  println(res)
}
