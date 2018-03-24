package com.fusl.demo1

class Person6 {

  protected var name:String = "tom"
  protected[this] var hobby:String = "game"
  protected def sayBye = println("再见")
}

class Student6 extends Person6{
  //父类使用 protected 关键字来修饰 field 可以直接访问
  def sayHello =println("Hello "+name)
  //父类使用 protected 关键字来修饰 method 可以直接访问
  def sayByeBye=sayBye

  def makeFriends(s:Student6)={
    println("My hobby is "+hobby+", your hobby is UnKnown")
  }
}

object Student6{

  def main(args: Array[String]): Unit = {
    val s:Student6=new Student6
    s.sayHello
    s.makeFriends(s)
    s.sayByeBye

  }
}
