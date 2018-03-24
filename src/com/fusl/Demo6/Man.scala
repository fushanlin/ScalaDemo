package com.fusl.Demo6

/**
  * 隐式转换案例（二）
  *
  */
class Man (val name:String)

class SuperMan(val name:String){
  def heat = println("超人大小怪兽")
}
object SuperMan{
  //隐式转换方法

  implicit def man2SuperMan(man:Man)=new SuperMan(man.name)

  def main(args: Array[String]): Unit = {
    val hero = new Man("hero")
    //Man 具备了SuperMan的方法
    hero.heat
  }
}
