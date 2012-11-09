import java.math.BigDecimal;

public class TestePontoFlutuante {
	public static void main(String[] args) {
		BigDecimal d1 = new BigDecimal("0.1");
		BigDecimal d2 =  new BigDecimal("0.2");
		System.out.println(d1.add(d2));
	}
}