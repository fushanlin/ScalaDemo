package com.fusl.demo1

/**
  *
  * scala中的抽象field
  */
abstract class Person10(val name:String) {

  //抽象fields
  val age:Int
}
class Student10(name:String)extends Person10(name){
  override val age: Int = 50
}
