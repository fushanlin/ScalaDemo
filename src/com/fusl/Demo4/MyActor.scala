
package com.fusl.Demo4

import scala.actors.Actor

class MyActor extends Actor{
  override def act(): Unit = {
    receive{
      case "start" => {

        println("starting...")
      }
    }
  }
}

object MyActor extends App{

  override def main(args: Array[String]): Unit = {
    val actor = new MyActor
    actor.start()
    actor ! "start"
    println("消息发送完成！")
  }
}
