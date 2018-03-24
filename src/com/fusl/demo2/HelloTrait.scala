package com.fusl.demo2

/**
  * scala中的trait作为接口使用，和Java中的接口非常类似
  */
trait HelloTrait {
  def sayHello(): Unit
}
trait  MakeFriendsTrait {
  def makeFriends(c: Children): Unit
}

//多重继承trait
class Children(val name: String) extends HelloTrait with MakeFriendsTrait with Cloneable with Serializable{
  def sayHello() =println("Hello, " + this.name)
  def makeFriends(c: Children) = println("Hello, my name is " + this.name + ", your name is " + c.name)
}

object Children{
  def main(args: Array[String]): Unit = {
    val c1=new Children("tom")
    val c2=new Children("jim")
    c1.sayHello()//Hello, tom
    c1.makeFriends(c2)//Hello, my name is tom, your name is jim
  }
}