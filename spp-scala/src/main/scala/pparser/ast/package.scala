package pparser

package object ast {
  implicit def value2Lit(value: Int) = Num(value)
  implicit def value2Lit(value: BigDecimal) = Num(value)
  implicit def value2Lit(value: String) = Str(value)
}