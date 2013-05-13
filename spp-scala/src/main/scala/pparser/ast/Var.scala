package pparser.ast

case class Var(routes: String*) {
  override def toString() = routes.mkString(".")
}