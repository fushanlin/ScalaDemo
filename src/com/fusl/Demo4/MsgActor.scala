package com.fusl.Demo4

import scala.actors.Actor


case class SyncMessage(id:Int,msg:String)//同步消息
case class AsyncMessage(id:Int,msg:String)//异步消息
case class ReplyMessage(id:Int,msg:String)//返回结果消息

class MsgActor  extends Actor{
  override def act(): Unit = {
    loop{
      react{
        case "start"=>{println("starting....")}
        case SyncMessage(id,msg)=>{
          println(s"id:$id, SyncMessage: $msg")
          Thread.sleep(2000)
          sender !ReplyMessage(1,"finished...")
        }
        case AsyncMessage(id,msg)=>{
          println(s"id:$id,AsyncMessage: $msg")
          // Thread.sleep(2000)
          sender !ReplyMessage(3,"finished...")
          Thread.sleep(2000)
        }
      }
    }

  }
}
object MainActor {
  def main(args: Array[String]): Unit = {
    val mActor=new MsgActor
    mActor.start()
    mActor!"start"
    //同步消息 有返回值
    val reply1= mActor!?SyncMessage(1,"我是同步消息")
    println(reply1)
    println("===============================")
    //异步无返回消息
    val reply2=mActor!AsyncMessage(2,"我是异步无返回消息")
    println("===============================")
    //异步有返回消息
    val reply3=mActor!!AsyncMessage(3,"我是异步有返回消息")
    //Future 的 apply()方法会构建一个异步操作且在未来某一个时刻返回一个值
    val result=reply3.apply()
    println(result)
  }
}


