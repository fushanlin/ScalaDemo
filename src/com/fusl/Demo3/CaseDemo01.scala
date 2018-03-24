package com.fusl.Demo3

import scala.util.Random

class CaseDemo01_1 {}
/**
  * 匹配字符串
  */
object CaseDemo01 extends App{

  val arr = Array("hadoop","zookeeper","spark")

  val name = arr(Random.nextInt(arr.length))

  name match {
    case "hadoop" => println("大数据分布式存储和计算框架。。。")
    case "zookeeper" => println("大数据分布协调框架。。。")
    case "spark" => println("大数据分布式内存计算框架。。。")
    case _ =>println("我不认识你。。。")
  }
}


/**
  * 匹配类型
  */
object CaseDemo01_1 extends App{

  val arr = Array("hello", 1, 2.0, CaseDemo01_1)
  val v = arr(Random.nextInt(4))
  println(v)
  v match {
    case x:Int =>println("Int" +x)
    case y:Double if (y>=0) => println("Double"+y)
    case z:String =>println("String" +z)
    case _ => throw new Exception("not match exception")
  }
}