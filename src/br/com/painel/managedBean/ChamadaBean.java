package br.com.painel.managedBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
@ManagedBean
public class ChamadaBean{
	
	InputStream audio;
	
	public ChamadaBean() throws IOException{
		this.audio = geraAudio();
	}
	
	public InputStream getAudio() {
		return audio;
	}

	public void setAudio(InputStream audio) throws IOException {
		this.audio = geraAudio();
	}

	public InputStream geraAudio() throws IOException{

		
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
		
		
		
		return br;
	}	

}