package com.fusl.demo1

class Person4 {
}

class Student4 extends Person4

object Student4{
  def main(args: Array[String]): Unit = {

    val p:Person4=new Student4
    //判断p是否为Person4的实例，
    println(p.isInstanceOf[Person4])
    //判断p的类型是否为Person4的类
    println(p.getClass == classOf[Person4])
    //判断p的类型是否为Student4的类
    println(p.getClass == classOf[Student4])
  }
}
