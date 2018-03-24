package com.fusl.demo2

/**
  * 使用混合的trait的具体方法和抽象方法
  */
trait ValidTrait {

  //抽象方法
  def getName:String

  //具体的方法，具体方法的返回值依赖于抽象方法
  def valid : Boolean = {"Tom".equals(this.getName)}
}

class PersonForValid(val name:String) extends ValidTrait{
  override def getName: String = this.name
}

object  PersonForValid{

  def main(args: Array[String]): Unit = {
    val person = new PersonForValid("Rose")

    println(person.valid)
  }
}