package com.fusl.demo1

/**
  * 使用模式匹配进行类型判断
  */
class Person5 {
}
class Student5 extends Person5
object Student5{
  def main(args: Array[String]): Unit = {
    val p:Person5 = new Person5
    p match {
      //匹配是否为person类或者其子类
      case per:Person5 => println("This is Person5 Object")
        //匹配所有剩余情况
      case _ => println("Unknown type!")
    }
  }
}
