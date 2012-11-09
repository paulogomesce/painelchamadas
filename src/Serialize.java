import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.Date;

public class Serialize {
	
	public static void main(String[] args) throws Exception {

		FileOutputStream f = new FileOutputStream("/home/paulo.gomes/Área de Trabalho/texto.txt");
	    ObjectOutput s = new ObjectOutputStream(f);
	    s.writeObject(new String("Francisco Paulo Ferreira Gomes"));
	    s.writeObject(new Date());
	    s.flush();		
		
	}
}
