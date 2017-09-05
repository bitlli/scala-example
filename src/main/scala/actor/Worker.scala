package actor

import akka.actor.{Actor, ActorRef}

 class Worker(matrixLeft:Map[Int,Map[Int,Int]],matrixRight:Map[Int,Map[Int,Int]], aggregator: ActorRef) extends Actor {

   def calculate(row: Int, col: Int): Int = 0

   override def receive = {
     case Multiple(row,col) =>
       println(s"Received worker message")
       aggregator ! MatrixCell(row, col, calculate(row,col))
       println(s"Call master Done")
       sender() ! Done
     case message: Any =>
       println(s"Received unexpected message: $message")
   }

 }
