/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ledes.hidra.controller;

import com.sun.jersey.multipart.FormDataMultiPart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import ledes.hidra.services.HidraServices;
import org.primefaces.model.UploadedFile;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author pedro
 */
@ManagedBean
@SessionScoped
public class Controller implements Serializable {

    private static final long serialVerionUID = 1L;

    private String path;
    private UploadedFile file;
    private FormDataMultiPart form;

    public Controller() {
    }

    public void initializeRepo() {

        HidraServices services = new HidraServices();
        String result = services.initialize(path);
        System.out.println(result);
    }

    public void fileUploadListener(FileUploadEvent e) {
        // Get uploaded file from the FileUploadEvent
        this.file = e.getFile();
        // Print out the information of the file
        System.out.println("\n\n\n\nUploaded File Name Is :: " + file.getFileName() +
                " :: Uploaded File Size :: " + file.getSize());
    }

    public void recebeArquivos(FileUploadEvent event) throws FileNotFoundException, IOException {
        byte[] arquivoBinario = event.getFile().getContents();

        //A partir daqui você tem o arquivo e pode fazer o que achar melhor com ele
        //Segue exemplo
        File f = new File("/var/wwww/hidra.com/hidra/REPOSITORIO/");

        FileOutputStream fos = new FileOutputStream(f);
        System.out.println("***************" + event.getFile().getFileName());
        fos.write(arquivoBinario);
        fos.close();
    }

    public void fileUploadAction(FileUploadEvent event) {
        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

            FacesContext aFacesContext = FacesContext.getCurrentInstance();
            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

            String realPath = context.getRealPath("/");

            // Aqui cria o diretorio caso não exista
            File f = new File(realPath + "/fotos/");
            f.mkdirs();

            byte[] arquivo = event.getFile().getContents();
            String caminho = realPath + "/fotos/" + event.getFile().getFileName();

            // esse trecho grava o arquivo no diretório
            FileOutputStream fos = new FileOutputStream(caminho);
            fos.write(arquivo);
            fos.close();

        } catch (Exception ex) {
            System.out.println("Erro no upload de imagem" + ex);
        }
    }

    public void doUpload(FileUploadEvent fileUploadEvent) {

        UploadedFile uploadedFile = fileUploadEvent.getFile();

        String fileNameUploaded = uploadedFile.getFileName();

        long fileSizeUploaded = uploadedFile.getSize();

        String infoAboutFile = "<br/> Arquivo recebido: <b>"
                + fileNameUploaded + "</b><br/>" + "Tamanho do Arquivo: <b>"
                + fileSizeUploaded + "</b>";

        FacesContext facesContext = FacesContext.getCurrentInstance();

        facesContext.addMessage(null, new FacesMessage("Sucesso", infoAboutFile));
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public FormDataMultiPart getForm() {
        return form;
    }

    public void setForm(FormDataMultiPart form) {
        this.form = form;
    }

}
