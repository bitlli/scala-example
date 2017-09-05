package actor

import akka.actor.{Actor, ActorRef, Props}

class Master(aggregator: ActorRef) extends Actor {

  import context._



  def waitDone(workers: Int) : Receive = {
    case Done =>
      println(s"Received master message Done")
      if(workers > 1) become(waitDone(workers-1)) else aggregator ! Done
  }

  override def receive = {
    case Start(workers, matrixRight, matrixLeft) =>
      println(s"Received master start")
      for (i <- 0 until workers;  j <- 0 until workers) {
        val worker = system.actorOf(Props(classOf[Worker], matrixLeft, matrixRight, aggregator))
        worker ! Multiple(i, j)
      }
      println(s"Received master become Done")
      become(waitDone(workers*workers))
    case message => println("Unknown"+message)
  }
}
