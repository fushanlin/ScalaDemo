package com.fusl.Demo6

import java.io.File

import scala.io.Source

/**
  * 隐式转换案例一，（让file类具备RichFile中的read方法）
  */
object MyPredef {
  //定义隐式转换方法
  implicit def file2RichFile(file: File)=new RichFile(file)
}

class RichFile(val f:File) {
  def read()=Source.fromFile(f).mkString
}

object  RichFile{
  def main(args: Array[String]): Unit = {
    val f=new File("D:\\aa.txt")
    //使用 import 导入隐式转换方法
    import MyPredef._
    //通过隐式转换，让 File 类具备了 RichFile 类中的方法
    val content=f.read()
    println(content)
  }
}
