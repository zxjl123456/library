/*package action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;

public class UploadAction extends ActionSupport {
    private File upload;
    private  String uploadFileName;

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public  String upload()throws Exception{
        InputStream inputStream=new FileInputStream(getUpload());
        OutputStream outputStream=new FileOutputStream("E:\\upload\\"+uploadFileName);
        byte buffer[]=new  byte[1024];
        int count=0;
        while((count=inputStream.read(buffer))>0){
            outputStream.write(buffer,0,count);
        }
        outputStream.close();
        inputStream.close();
        return SUCCESS;
    }

}*/
