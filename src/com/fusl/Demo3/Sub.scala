package com.fusl.Demo3

class Super

class Sub extends Super{}

//协变
class Temp1[+A](title:String)

//逆变
class Temp2[-A](title:String)

//非变
class Temp3[A](title:String)

object Covariance_demo{

  def main(args: Array[String]): Unit = {

    //支持协变 Temp1[Sub]还是 Temp1[Super]的子类
    val t1: Temp1[Super] = new Temp1[Sub]("hello scala!!!")

    //支持逆变 Temp1[Super]是 Temp1[Sub]的子类
    val t2: Temp2[Sub] = new Temp2[Super]("hello scala!!!")

    //支持非变 Temp3[Super]与 Temp3[Sub]没有从属关系，如下代码会报错
    //val t3: Temp3[Sub] = new Temp3[Super]("hello scala!!!")
    //val t4: Temp3[Super] = new Temp3[Sub]("hello scala!!!")
    println(t1.toString)
    println(t2.toString)

  }
}