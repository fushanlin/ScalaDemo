package com.fusl.Demo5

import scala.actors.{Actor, Future}
import scala.collection.immutable.HashSet.HashSet1
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * 利用actor的并发编程来实现单机版的word count程序，将多个文件作为输入，先进行局部汇总，然后进行全局汇总
  * 最终得到结果
  */

case class SubmitTask(filename:String)
case class ResultTask(result:Map[String,Int])

class Task extends Actor{

  override def act(): Unit = {
    loop{
      react{
        case SubmitTask(filename) => {
          //1,利用source读取文件内容
          val content : String = Source.fromFile(filename).mkString
          //按照换行符切分  windows下的文件的换行符是\r\n 在Linux中是\n
          val lines : Array[String] = content.split("\r\n")
          //3,切分每一行，获取所有的单词
          val words: Array[String] = lines.flatMap(_.split(" "))
          //println(words.toBuffer)
          //println(content)
          //每个单词记为1
          //words.map(x => (x,1))
          val wordAndOne:Array[(String,Int)] = words.map((_,1))
          //println(wordAndOne.toBuffer)
          //5,相同单词进行分组
          val wordGroup: Map[String, Array[(String,Int)]] = wordAndOne.groupBy(_._1)
          //println(wordGroup.toBuffer)
          //6,统计每个单词出现的次数
          val result: Map[String,Int] = wordGroup.mapValues(_.length)
          //println(result.toBuffer)
          //7,返回消息给发送方
          sender ! ResultTask(result)
        }
      }
    }
  }
}


object WordCount{
  def main(args: Array[String]): Unit = {
    //定义一个集合用于存放future
    val replySet = new mutable.HashSet[Future[Any]]()
    //定义一个list集合，用于存放真正的数据
    val taskList = new ListBuffer[ResultTask]
    //准备数据文件
    val files = Array("D:\\aa.txt","D:\\aa.txt","D:\\aa.txt")
    //遍历文件数组，提交任务
    for (file <- files){
      val task = new Task
      //启动
      task.start()
      //发送消息
      val reply: Future[Any] = task !! SubmitTask(file)
      //添加结果到replySet集合中
      replySet += reply
    }

    //遍历set集合
    while (replySet.size > 0){
      //过滤出真正有结果数据的future
      val toCompleted:mutable.HashSet[Future[Any]] = replySet.filter(_.isSet)
      //遍历toCompleted
      for (t <- toCompleted){
        //获取future中真正的数据
        val apply:Any = t.apply()
        //添加数据到list集合中
        taskList += apply.asInstanceOf[ResultTask]
        //在set集合中移除掉已经添加到list集合中的Future数据
        replySet -= t
      }
    }

    //println(taskList.map(_.result))
    val finalResult = taskList.map(_.result).flatten.groupBy(_._1).mapValues(x =>x.foldLeft(0)(_ + _._2))
    println(finalResult)
  }
}