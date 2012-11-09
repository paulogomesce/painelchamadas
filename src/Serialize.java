import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Serialize {
	
	public static void main(String[] args) throws Exception {

		FileOutputStream f = new FileOutputStream("/home/paulo.gomes/Ã�rea de Trabalho/texto.txt");
	    @SuppressWarnings("resource")
		ObjectOutput s = new ObjectOutputStream(f);
	    s.writeObject(new String("Francisco Paulo Ferreira Gomes"));
	    s.writeObject(new Date());
	    s.flush();		
		
	}
}
