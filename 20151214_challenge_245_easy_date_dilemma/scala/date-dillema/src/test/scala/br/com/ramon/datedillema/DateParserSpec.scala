package br.com.ramon.datedillema

import org.scalatest.Matchers._
import org.scalatest.{FeatureSpec, GivenWhenThen}
import org.scalatest.prop.TableDrivenPropertyChecks._

/**
  * Created by ramon on 27/06/16.
  * @see https://www.reddit.com/r/dailyprogrammer/comments/3wshp7/20151214_challenge_245_easy_date_dilemma/
  */
class DateParserSpec extends FeatureSpec with GivenWhenThen {
  info("As a developer I want to normalize all the messy text into properly ISO 8601 (YYYY-MM-DD) formatted dates")
  feature("Normalize date") {
    scenario("Date input") {
      val dates =
        Table(
          ("input", "output"),
          ( "2/13/15","2015-02-13"),
          ( "1-31-10","2010-01-31"),
          ( "5 10 2015","2015-05-10"),
          ( "2012 3 17", "2012-03-17"),
          ( "2001-01-01", "2001-01-01"),
          ( "2008/01/07", "2008-01-07")
        )
      val dateParser = new DateParser
      forAll(dates) {(input : String , output : String) =>
        Given("a input date " + input)
        When("the date is normalized")
        val normalized = dateParser.parse(input)

        Then(s"the normalized date should be $output")
        normalized shouldBe output
      }
    }
  }
}
