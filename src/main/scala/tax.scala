class Tax(income: Float, costs: Float, rate: Int) {

   def calculate() : Float = ((income - costs) * (100 + rate)) / 100

}
