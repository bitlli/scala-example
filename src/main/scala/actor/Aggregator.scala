package actor
import akka.actor._

class Aggregator(resultMatrix: Map[Int,Map[Int,Int]])  extends Actor {

  import context._

  def add(i: Int, j: Int, num: Int, intToInt: Map[Int, Int], matrix: Map[Int,Map[Int,Int]]) = {
    val newMatrix=matrix + (i -> (intToInt + (j -> num)))
    become(collectData(newMatrix))
  }

  override def receive = collectData(resultMatrix)

  def collectData(matrix: Map[Int,Map[Int,Int]]): Receive = {
    case MatrixCell(row,col,num) =>
      println(s"Received aggregator matrix data:$row $col and result $num")
      add(row, col, num, matrix.getOrElse(row, Map()), matrix)
    case Done => println("The result matrix: "+ matrix)
    case message: Any =>
      println(s"Received unexpected message: $message")
  }
}
