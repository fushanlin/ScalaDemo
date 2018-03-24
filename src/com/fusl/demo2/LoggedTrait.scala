package com.fusl.demo2

/**
  * 在实例对象中指定混入某个trait
  */
trait LoggedTrait {
  //该方法为实现的具体方法
  def log(msg:String) ={}
}
trait MyLogger extends LoggedTrait{
  //覆盖log()方法
  override def log(msg:String) = println("log:"+msg)
}

class  PersonForMixTraitMethod(val name:String)extends LoggedTrait{
  def sayHello = {
    println("Hi,I'm"+this.name)
    log("sayHello method is invoked!")
  }
}

object  PersonForMixTraitMethod{
  def main(args: Array[String]): Unit = {
    val tom = new PersonForMixTraitMethod("tom").sayHello
    // 使用 with 关键字，指定混入 MyLogger trait
    val rose = new PersonForMixTraitMethod("Rose") with MyLogger
    rose.sayHello
  }
}

