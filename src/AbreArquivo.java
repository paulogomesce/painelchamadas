import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;



public class AbreArquivo {

	public static void main(String[] args) throws IOException {  
	      
        String urlString = "http://translate.google.com.br/translate_tts";
        
        Properties parameters = new Properties();
        parameters.setProperty("q","Paulo");  
        parameters.setProperty("tl","pt");
        parameters.setProperty("prev","output");
        
        Iterator i = parameters.keySet().iterator();  
        // o contador  
        int counter = 0;  

        while (i.hasNext()) {  
        	  
            // pega o nome  
            String name = (String) i.next();  
            // pega o valor  
            String value = parameters.getProperty(name);  
          
            // adiciona com um conector (? ou &)  
            // o primeiro é ?, depois são &  
            urlString += (++counter == 1 ? "?" : "&")  
                + name  
                + "="  
                + value;  
          
        }
        
        System.out.println(urlString);
        URL url = null;
        url = new URL(urlString);
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestProperty("Request-Method", "GET"); 
        
        connection.setDoInput(true);  
        connection.setDoOutput(false);
        
        connection.connect(); 
        
        InputStream br = connection.getInputStream();
        
        File file = new File("d://teste.mp3");  
        OutputStream out = new FileOutputStream(file, false); 
        
        int i2=0;  
        while ((i2 = br.read()) != -1){  
            out.write(i2);  
        }  
        br.close();  
        out.close();  
        System.out.println("Gravação efetuada com sucesso"); 
        
        //File file = new File("http://translate.google.com.br/translate_tts?ie=UTF-8&q=rita%20de%20c%C3%A1ssia%20ferreira%20gomes&tl=pt&total=1&idx=0&textlen=30&prev=input.mp3");
	}
}


























