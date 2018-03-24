package com.fusl.demo

/**
  *  Array 类的伴生对象中，就实现了可接收变长参数的 apply 方法，
  * 并通过创建一个 Array 类的实例化对象，实现了伴生对象的构造函数功能
  */
// 指定 T 泛型的数据类型，并使用变长参数 xs 接收传参，返回 Array[T] 数组
// 通过 new 关键字创建 xs.length 长的 Array 数组
// 其实就是调用Array伴生类的 constructor进行 Array对象的初始化
//  def apply[T: ClassTag](xs: T*): Array[T] = {
//    val array = new Array[T](xs.length)
//    var i = 0
//    for (x <- xs.iterator) { array(i) = x; i += 1 }
//    array
//  }
object ApplyDemo {

  def main(args: Array[String]) {
    //调用了Array伴生对象的apply方法
    //def apply(x: Int, xs: Int*): Array[Int]
    //arr1中只有一个元素5
    val arr1 = Array(5)
    //new了一个长度为5的array，数组里面包含5个null
    var arr2 = new Array(5)
    println(arr1.toBuffer)
  }

}
