package pparser

package object ast {
  implicit def value2Lit(value: Int) = NumberLit(value)
  implicit def value2Lit(value: BigDecimal) = NumberLit(value)
  implicit def value2Lit(value: String) = StringLit(value)
}