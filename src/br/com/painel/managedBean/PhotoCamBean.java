package br.com.painel.managedBean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class PhotoCamBean {
   
    private List<StreamedContent> photos = new ArrayList<StreamedContent>();    
    private FileImageOutputStream imageOutput;
    private StreamedContent foto;
    
    
    private String gerarNomeDaImagem() {
		int i = (int) (Math.random() * 10000000);		
		return String.valueOf(i);
	}

	public void onCapture(CaptureEvent captureEvent) {
        String photo = gerarNomeDaImagem();

        byte[] data = captureEvent.getData();
        
		@SuppressWarnings("unused")
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		//String newFileName = servletContext.getRealPath("") + File.separator + "photocam" + File.separator + photo + ".png";
		
		String newFileName = "d:\\" + photo + ".jpg";
		
		System.out.println("Nome do arquivo: "+newFileName);
		
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
			
			ByteArrayInputStream inputStream = new ByteArrayInputStream(data); 
			
			foto = new DefaultStreamedContent(inputStream, "image/png");
			
			this.photos.add(foto);
			
		}
        catch(Exception e) {
			throw new FacesException("Error in writing captured image.");
		}
    }

	public List<StreamedContent> getPhotos() {
		return photos;
	}

	public void setPhotos(List<StreamedContent> photos) {
		this.photos = photos;
	}

	public FileImageOutputStream getImageOutput() {
		return imageOutput;
	}

	public void setImageOutput(FileImageOutputStream imageOutput) {
		this.imageOutput = imageOutput;
	}

	public StreamedContent getFoto() {
		return foto;
	}

	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}
	
	
	
}
                        