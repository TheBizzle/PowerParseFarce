package parser

import scala.util.parsing.combinator.RegexParsers

/**
 * Created by IntelliJ IDEA.
 * User: Jason
 * Date: 2/25/12
 * Time: 9:51 PM
 */

object PowerParser extends RegexParsers {

    val NUM = """[1-9][0-9]*""".r

}
