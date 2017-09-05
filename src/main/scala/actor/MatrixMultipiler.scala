package actor

import akka.actor.{ActorSystem, Props}


case class MatrixCell(row: Int, col: Int, num:Int)
case class Multiple(row: Int, col: Int)
case class Start(worker: Int, matrixLeft:Map[Int,Map[Int,Int]], matrixRight:Map[Int,Map[Int,Int]])
case object Done

object MatrixMultipiler extends App {

  val system = ActorSystem("matricies")

  val matrixLeft = Map(
    0->Map(0 -> 1, 1 -> 2, 2 -> 4),
    1->Map(0 -> 1, 1 -> 2, 2 -> 4),
    2->Map(0 -> 1, 1 -> 2, 2 -> 4)
  )
  println(s"==================")

  val matrixRight = Map(
    0->Map(0 -> 1, 1 -> 0, 2 -> 0),
    1->Map(0 -> 0, 1 -> 1, 2 -> 0),
    2->Map(0 -> 0, 1 -> 0, 2 -> 1)
  )

  def doCalculation(): Unit ={
    println(s"Start")
   val aggregator = system.actorOf(Props(classOf[Aggregator], Map()), "aggregator")
   val master = system.actorOf(Props(classOf[Master], aggregator), "master")
    master ! Start(3, matrixLeft, matrixRight)

  }
  doCalculation()

}
