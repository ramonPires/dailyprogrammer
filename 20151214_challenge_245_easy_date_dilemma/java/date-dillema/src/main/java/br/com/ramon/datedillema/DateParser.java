package br.com.ramon.datedillema;

public class DateParser{

	public String parse(String date){
		String[] splitted = splitDate(date);

		String formatedDate = "";

		if (splitted[0].length() <= 2) {
			formatedDate = formatPatternMDY(splitted);
		} else if (splitted[0].length() == 4) {
			formatedDate = formatPatternYMD(splitted);
		}

		return formatedDate;
	}

	private String formatPatternYMD(String[] splittedDate){
		String year = "";
		String month = "";
		String day = "";
		
		year = formateYear(splittedDate[0]);

		month = formateMonth(splittedDate[1]);
		
		day = formateDay(splittedDate[2]);

		return year+"-"+month+"-"+day;
	}

	private String formatPatternMDY(String[] splittedDate){
		String year = "";
		String month = "";
		String day = "";
		month = formateMonth(splittedDate[0]);
		
		day = formateDay(splittedDate[1]);

		year = formateYear(splittedDate[2]);

		return year+"-"+month+"-"+day;
	}

	private String[] splitDate(String date){
		if (date.indexOf('/') > -1) {
			return date.split("/");	
		}

		if (date.indexOf('-') > -1) {
			return date.split("-");
		}

		if (date.indexOf(' ') > -1) {
			return date.split(" ");
		}

		return new String[]{};
	}

	private String formateMonth(String month){
		if (month.length() <= 2) {
			return formatNumberLowerThan10(month);
		}
		return month;
	}

	private String formateDay(String day){
		if (day.length() <= 2) {
			return formatNumberLowerThan10(day);	
		}
		return day;
	}

	private String formateYear(String year){
		if (year.length() <= 2) {
			return "20" + formatNumberLowerThan10(year);	
		}
		return year;		
	}

	private String formatNumberLowerThan10(String number){
		if (number.length() == 1) {
			return "0" + number;
		}
		return number;
	}
}