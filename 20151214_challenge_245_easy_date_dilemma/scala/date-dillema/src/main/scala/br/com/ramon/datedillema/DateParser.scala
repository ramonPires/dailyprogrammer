package br.com.ramon.datedillema

/**
  * Created by ramon on 27/06/16.
  */
class DateParser {
  def parse(input: String): String = {
    val splitedDate = splitDate(input)
    val formatedDate = splitedDate.head.length match {
      case mdy if mdy <= 2 => formatPatternMDY(splitedDate)
      case ymd if ymd == 4 => formatPatternYMD(splitedDate)
    }
    formatedDate
  }

  private def splitDate(date: String): Array[String] = {
    Array("/", "-", " ").foreach { c =>
      if (date.indexOf(c) > -1) return date.split(c)
    }
    new Array[String](0)
  }

  private def formatPatternYMD(splittedDate: Array[String]): String = {
    val year = formateYear(splittedDate(0))

    val month = formateMonth(splittedDate(1))

    val day = formateDay(splittedDate(2))

    year + "-" + month + "-" + day
  }

  private def formatPatternMDY(splittedDate: Array[String]): String = {
    val month = formateMonth(splittedDate(0))

    val day = formateDay(splittedDate(1))

    val year = formateYear(splittedDate(2))
    year + "-" + month + "-" + day
  }


  private def formateMonth(month: String): String = {
    if (month.length() <= 2) {
      return formatNumberLowerThan10(month)
    }
    month
  }

  private def formateDay(day: String): String = {
    if (day.length() <= 2) {
      return formatNumberLowerThan10(day)
    }
    day
  }

  private def formateYear(year: String): String = {
    if (year.length() <= 2) {
      return "20" + formatNumberLowerThan10(year)
    }
    year
  }

  private def formatNumberLowerThan10(number: String): String = {
    if (number.length() == 1) {
      return "0" + number
    }
    number
  }

}
