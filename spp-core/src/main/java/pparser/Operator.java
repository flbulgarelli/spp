package pparser;

/**
 * Binary operators for binary operators predicates.
 * 
 * These operators do not provide any behaviour, as it is dependent of the
 * client of the spp library
 * 
 * @author flbulgarelli
 */
public enum Operator {
  /** == operator */
  EQ,
  /** != operator */
  NEQ,
  /** < operator */
  LT,
  /** < operator */
  GT,
  /** >= operator */
  GTE,
  /** <= operator */
  LTE
}
