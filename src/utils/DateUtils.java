package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils{
	
	public static String getEuropeDate(Date date){
		Date dte = date;//or something else
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String formattedDate = formatter.format(dte);
		return formattedDate;    
	}
}  