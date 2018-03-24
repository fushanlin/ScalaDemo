package com.fusl.demo

/**
  * 每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起
  * @param name
  * @param age
  */
class Student2(val name: String,var age:Int) {

  //主构造器会执行类定义的所有语句
  println("执行主构造器")
  private var gender = "male"

  def this(name: String,age:Int,gender:String){
    //每个辅助构造器，执行必须以主构造器或者其他辅助构造器的调用开始
    this(name,age)
    println("执行辅助构造器")
    this.gender = gender
    println("执行辅助构造器")
  }
}

object Student2{
  def main(args: Array[String]): Unit = {
//    val s1 = new Student("zhangsan",20)
//    val s2 = new Student("zhangsan",20,"female")
  }
}
