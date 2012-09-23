package br.com.painel.converters;

import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.painel.util.DateUtil;

@FacesConverter("dataHoraConverter")
public class ConverterDataHora implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String dataHora) {
		return DateUtil.criarDataHora(dataHora);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object dataHota) {
		String dataConvertida = null;
		
		Date dataTemp = (Date)dataHota;
		System.out.println("data na hora da conversão" + dataTemp);
		dataConvertida = DateUtil.formatarDatahoraPtBR(dataTemp);		
		return dataConvertida;
	}

	
}
