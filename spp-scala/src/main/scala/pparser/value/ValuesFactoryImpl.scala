package pparser.value
import pparser.ast._
import pparser.ValuesFactory
import scala.collection.JavaConversions._
object ValuesFactoryImpl extends ValuesFactory {
  
  override def createString(tokenImage : String) = tokenImage.substring(1, tokenImage.length() - 1)
  
  override def createNumber(tokenImage : String)  = BigDecimal(tokenImage) 

  override def createPath(tokenImages : java.util.List[String]) = Var(tokenImages : _*)

}