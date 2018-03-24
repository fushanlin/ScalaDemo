package com.fusl.Demo6

class C

class A(c:C){
  def readBook():Unit = {
    println("A说：好书好书。。。")
  }
}
class B(c:C){
  def readBook():Unit={
    println("B说：看不懂。。。")
  }
  def writeBook():Unit={
    println("B说：不会写")
  }
}
object AB{
  //创建一个类的 2 个类的隐式转换
  implicit def C2A(c:C)=new A(c)
  implicit def C2B(c:C)=new B(c)
}
object B{
  def main(args: Array[String]): Unit = {
    //导包
    //1. import AB._ 会将 AB 类下的所有隐式转换导进来
    //2. import AB._C2A 只导入 C 类到 A 类的的隐式转换方法
    //3. import AB._C2B 只导入 C 类到 B 类的的隐式转换方法

    import AB._
    val c = new C
    //由于 A 类与 B 类中都有 readBook()，只能导入其中一个，否则调用共同方法时代码报错
    //c.readBook()
    //C 类可以执行 B 类中的 writeBook()
    c.writeBook()

  }
}
