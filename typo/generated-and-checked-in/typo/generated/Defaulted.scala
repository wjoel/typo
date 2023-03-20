/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated




/**
 * This signals a value where if you don't provide it, postgres will generate it for you
 */
sealed trait Defaulted[+T]

object Defaulted {
  case class Provided[T](value: T) extends Defaulted[T]
  case object UseDefault extends Defaulted[Nothing]
  
}
