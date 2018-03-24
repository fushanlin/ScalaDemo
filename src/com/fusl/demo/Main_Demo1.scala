package com.fusl.demo

object Main_Demo1 {
  def main(args: Array[String]) {
    if(args.length > 0){
      println("Hello, " + args(0))
    }else{
      println("Hello World!")
    }
  }
}
//2.使用继承App Trait ,将需要写在 main 方法中运行的代码
// 直接作为 object 的 constructor 代码即可，
// 而且还可以使用 args 接收传入的参数。
object Main_Demo2 extends App{
  if(args.length > 0){
    println("Hello, " + args(0))
  }else{
    println("Hello World!")
  }
}
