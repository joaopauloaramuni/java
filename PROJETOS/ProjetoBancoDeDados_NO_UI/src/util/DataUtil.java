package util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DataUtil {

	public static Date converter( Calendar calendar ){
		return new Date( calendar.getTimeInMillis() );
	}

	public static Calendar converter( Date date ){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar;
	}
	
	public static Date converterToDate( String data, String formato ){
		
		SimpleDateFormat dtf = new SimpleDateFormat(formato);
		try {
			return dtf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Calendar converterToCalendar( String data, String formato ){
		
		SimpleDateFormat dtf = new SimpleDateFormat(formato);
		try {
			
			Calendar cal = new GregorianCalendar();
			cal.setTime(dtf.parse(data));
			return cal;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void exibir( Date data, String formato ){
		SimpleDateFormat dtf = new SimpleDateFormat(formato);
		System.out.println( dtf.format(data) );		
	}
	
	
	public static String converter( Date data, String formato ){
		SimpleDateFormat dtf = new SimpleDateFormat(formato);
		return dtf.format(data);		
	}

	public static String converter( Calendar calendar, String formato ){
		SimpleDateFormat dtf = new SimpleDateFormat(formato);
		Date data = new Date( calendar.getTimeInMillis() );
		return dtf.format(data);		
	}
	
	//Desconsidera anos bissextos
	public static int calculaIdade( Calendar calendar ) {		
		Calendar now = new GregorianCalendar();		
		Long difMS = now.getTimeInMillis() - calendar.getTimeInMillis();		
		Long difAnos = (difMS / (1000 * 60 * 60 * 24)) / 365;		
		return difAnos.intValue();
	}

	//Desconsidera anos bissextos
	public static int calculaIdade( Date data ) {		
		Date now = new Date();		
		Long difMS = now.getTime() - data.getTime();		
		Long difAnos = (difMS / (1000 * 60 * 60 * 24)) / 365;		
		return difAnos.intValue();
	}
	
	public static String comparaDatas( Date data1, Date data2 ){
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String str = null;
		if ( data1.compareTo(data2) < 0 )
			str = "A data " + dtf.format(data1) + " é menor que a data " + dtf.format(data2);
		else if ( data1.compareTo(data2) == 0 )
			str = "A datas " + dtf.format(data1) + " e " + dtf.format(data2) + " são iguais";
		else if ( data1.compareTo(data2) > 0 )
			str = "A data " + dtf.format(data1) + " é maior que a data " + dtf.format(data2);
	
		return str;
	}
	
	public static String estacaoAno( Calendar calendar ) {		
		Calendar outono = new GregorianCalendar(2017,02,20,7,29);
		Calendar inverno = new GregorianCalendar(2017,5,21,1,24);
		Calendar primavera = new GregorianCalendar(2017,8,22,17,2);
		Calendar verao = new GregorianCalendar(2017,11,21,13,28);
		
		if ( (calendar.get(Calendar.YEAR) == 2017) &&
			 calendar.getTimeInMillis() < outono.getTimeInMillis() ) 
			return "VERAO";
		else if ( calendar.getTimeInMillis() >= outono.getTimeInMillis() && 
			 calendar.getTimeInMillis() < inverno.getTimeInMillis() )
			return "OUTONO";
		else if ( calendar.getTimeInMillis() >= inverno.getTimeInMillis() && 
				 calendar.getTimeInMillis() < primavera.getTimeInMillis() )
			return "INVERNO";
		else if ( calendar.getTimeInMillis() >= primavera.getTimeInMillis() && 
				 calendar.getTimeInMillis() < verao.getTimeInMillis() )
			return "PRIMAVERA";
		else if ( calendar.getTimeInMillis() >= verao.getTimeInMillis() ) 
			return "VERAO";
		else
			return "Data fora do intervalo do calendário de 2017";
	}
	
}
