package com.fusl.Demo3

import scala.util.Random

/**
  * 样例类，在Scala中样例类是一个特殊的类，可以用于模式匹配
  *
  * case class 类型，是多例的，后面要跟构造参数
  * case object 类型是单例的
  */

case class SubmitTask(id:String,name: String)
case class HeartBeat(time:Long)
case object CheckTimeOutTask

object CaseDemo04 extends App{
  val arr = Array(CheckTimeOutTask, HeartBeat(12333), SubmitTask("0001", "task-0001"))
  arr(Random.nextInt(arr.length)) match {
    case SubmitTask(id,name) => {
      println(s"$id, $name")
    }
    case HeartBeat(time) =>{
      println(time)
    }
    case CheckTimeOutTask=>{
      println("check")
    }
  }
}
