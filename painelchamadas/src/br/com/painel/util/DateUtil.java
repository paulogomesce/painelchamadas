package br.com.painel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat formatoDaData     = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat formatoDaDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static Date criarData(String dataDigitada) {
		try {
			return formatoDaData.parse(dataDigitada);
		} catch (ParseException e){
			FacesMessageUtil.addErro("Erro ao converter a data."); 
			return null;
		}
	}
	
	public static Date criarDataHora(String dataHoraDigitada) {
		try {
			return formatoDaDataHora.parse(dataHoraDigitada);
		} catch (ParseException e){
			FacesMessageUtil.addErro("Erro ao converter a data e a hora."); 
			return null;
		}
	}

	public static String formatarDataPtBR(Date data){
		return formatoDaData.format(data);
	}

	public static String formatarDatahoraPtBR(Date dataHora){
		return formatoDaDataHora.format(dataHora);
	}
	
}
