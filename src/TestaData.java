

import java.util.Date;

import br.com.painel.util.DateUtil;

public class TestaData {

	public static void main(String[] args) {
		System.out.println(DateUtil.criarData("14/08/196 11:10:55"));
		
		System.out.println(DateUtil.criarDataHora("14/08/196 11:10:55"));
		
		System.out.println(new Date());
	}
}
