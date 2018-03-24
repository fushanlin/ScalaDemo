package com.fusl.demo1

/**
  * scala中的抽象类
  */
abstract class Person9(val name:String) {

  //必须指出返回类型，不然默认返回为 Unit
  def sayHello:String
  def sayBye:String
}
class Student9(name:String)extends Person9(name){
  override def sayHello: String = "hello"+name

  override def sayBye: String = "Bye"+name
}

object Student9{
  def main(args: Array[String]): Unit = {
    val s = new Student9("tom")
    println(s.sayHello)
    println(s.sayBye)
  }
}
