package parser

import util.parsing.combinator.RegexParsers

/**
 * Created by IntelliJ IDEA.
 * User: Jason
 * Date: 2/25/12
 * Time: 10:19 PM
 */

object EnglishParser extends RegexParsers {

    val MixedTerm = """[\.0-9a-zA-Z]+""".r

    val NumericalTerm = """[1-9](([0-9]*)|([0-9]?[0-9]?(,[0-9]{3})*))(\.[0-9]+)?""".r

    val TextualTerm = """[a-zA-Z]([a-zA-Z]|('[a-zA-Z]))*""".r

    val Punctuation = """,|:|—|/|-""".r

    val BlockEnd = """\)|"|\]|\}|>""".r

    val BlockStart = """\(|"|\[|\{|<""".r

    val Word = opt(BlockStart) ~ TextualTerm | NumericalTerm | MixedTerm ~ opt(BlockEnd)

    val IndependentClause = rep1sep(Word, opt(Punctuation))

    val SentenceEnding = """((\.|!|\?)  ?)|$""".r

    val Sentence = rep1sep(IndependentClause, """(; )|(—)""".r) ~ SentenceEnding

}
