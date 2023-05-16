/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded




/**
 * This signals a value where if you don't provide it, postgres will generate it for you
 */
sealed trait Defaulted[+T]

object Defaulted {
  case class Provided[T](value: T) extends Defaulted[T]
  case object UseDefault extends Defaulted[Nothing]
  
}
