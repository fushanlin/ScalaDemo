package com.fusl.demo1

/**
  * scala中的匿名内部类
  */
class Person8(val name:String){
  def sayHello="Hello,I'm"+name
}
class  GreetDemo{
  //接受 Person8 参数，并规定 Person8 类只含有一个返回 String 的 sayHello
  def greeting(p:Person8{def sayHello:String})= {
    println(p.sayHello)
  }
}
object GreetDemo {
  def main(args: Array[String]): Unit = {
    //创建 Person8 的匿名子类对象val p=new Person8("tom")val g=new GreetDemog.greeting(p)
    val p=new Person8("tom")
    val g=new GreetDemo
    g.greeting(p)
  }
}
