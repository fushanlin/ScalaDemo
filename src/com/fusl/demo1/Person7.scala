package com.fusl.demo1

/**
  * 调用父类中的constructor
  * @param name
  * @param age
  */
class Person7(val name:String, val age:Int) {

  var score :Double = 0.0
  var address:String = "beijing"
  def this(name :String ,score:Double){
    //每个辅助 constructor 的第一行都必须调用其他辅助 constructor 或者主 constructor 代码
    //主 constructor 代码
    this(name,30)
    this score = score;
  }

  //其他辅助 construct
  def this (name :String ,address:String)={
    this(name,100.0)
    this.address=address
  }

  class Student7(name:String,score:Double) extends Person7(name,score)
}


