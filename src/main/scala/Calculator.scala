
object Calculator {

  val bankNotes : List[Int]  = List(5, 10, 20, 50, 100, 200, 500, 1000, 2000,5000, 10000, 20000 ).reverse

  def returnNotes(cost: Int) : Map[Int,Int] = returnNotes(corrected(cost),Map[Int, Int](),bankNotes)

  def returnNotes(cost: Int, result: Map[Int,Int], actualNotes: List[Int]) : Map[Int,Int] = {
    if(actualNotes.nonEmpty && cost != 0 ) {
      returnNotes(cost-(cost/actualNotes.head)*actualNotes.head,add(result,(cost/actualNotes.head->actualNotes.head)),actualNotes.tail)
    }  else {
      result
    }
  }
  def add(result: Map[Int,Int], element: (Int, Int)) = if(element._1 != 0) result + element else result
  
  def corrected(cost: Int) = if( cost%5 != 0) cost + (5-cost%5) else cost
}
