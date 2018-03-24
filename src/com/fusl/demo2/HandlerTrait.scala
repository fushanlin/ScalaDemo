package com.fusl.demo2

/**
  * Trait调用链
  */
trait HandlerTrait {
  def handle(data: String) = {println("last one")}
}
trait  DataValidHandlerTrait extends HandlerTrait{

  override def handle(data: String) = {
    println("check data:"+data)
    super.handle(data)
  }
}

trait  SignatureValidHandlerTrait extends HandlerTrait{
  override def handle(data: String): Unit = {
    println("check signature: " + data)
    super.handle(data)
  }
}

class  PersonForRespLine (val name:String) extends SignatureValidHandlerTrait with DataValidHandlerTrait{

  def sayHello ={
    println("hello,"+this.name)
    this.handle(this.name)
  }
}

object PersonForRespLine{

  def main(args: Array[String]): Unit = {
    val p = new PersonForRespLine("tom")
    p.sayHello
  }
}