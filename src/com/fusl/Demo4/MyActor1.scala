package com.fusl.Demo4

import scala.actors.Actor

class MyActor1 extends Actor{
  override def act(): Unit = {
    while (true){
      receive{
        case "start" =>{
          println("starting...")
        }
        case "stop" => {
          println("stop...")
        }
      }
    }
  }
}

object MyActor1 extends App{
  override def main(args: Array[String]): Unit = {
    val actor = new MyActor1
    actor.start()
    actor ! "start"
    actor ! "stop"
  }
}
