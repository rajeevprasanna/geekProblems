package arrays

/**
  * Created by rajeevprasanna on 2/27/16.
  */

//Hexa decimal to Integer conversion
object p11 extends App {

 //def hexaToInt(s:String):Int = s.toList.map("0123456789abcdef".indexOf(_)).reduceLeft(_*16 + _)
  def convertToInt(s:String, baseValues:String):Int = s.toList.map(baseValues.indexOf(_)).reduceLeft(_*baseValues.length + _)
  val v = convertToInt("123", "0123456789abcdef") //For hexa to Int converstion
  println(v)//3 + 32+ 256

}
