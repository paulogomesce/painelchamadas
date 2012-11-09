package br.com.painel.managedBean;

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

@ManagedBean
@SessionScoped
public class PhotoCamBean {
   
    private List<FileImageOutputStream> photos = new ArrayList<FileImageOutputStream>();    
    private FileImageOutputStream imageOutput;    
    private String gerarNomeDaImagem() {
		int i = (int) (Math.random() * 10000000);		
		return String.valueOf(i);
	}

    public List<FileImageOutputStream> getPhotos() {
        return photos;
    }    
    
    
    public FileImageOutputStream getImageOutput() {
		return imageOutput;
	}

	public void setImageOutput(FileImageOutputStream imageOutput) {
		this.imageOutput = imageOutput;
	}

	public void setPhotos(List<FileImageOutputStream> photos) {
		this.photos = photos;
	}

	public void onCapture(CaptureEvent captureEvent) {
        String photo = gerarNomeDaImagem();

        byte[] data = captureEvent.getData();
        
		@SuppressWarnings("unused")
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		//String newFileName = servletContext.getRealPath("") + File.separator + "photocam" + File.separator + photo + ".png";
		
		String newFileName = "d:\\" + photo + ".jpg";
		
		System.out.println("Nome do arquivo: "+newFileName);
		
        this.photos.add(imageOutput);
		
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
		}
        catch(Exception e) {
			throw new FacesException("Error in writing captured image.");
		}
    }
}
                        