package com.hicx.challenge;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.File;

@Data
@Builder
public class FileEntity {

    private String path;
    private String fileType;
    private String name;
    private String directory;


    public FileEntity withFileType(){
        this.fileType = StringUtils.getFilenameExtension(this.path);
        return this;
    }

    public void moveToProccessed() throws Exception {
        try{
            File newFolder = new File(this.directory+"/"+Constants.NEW_FOLDER.value);
            File targetFile = new File(this.directory+"/"+Constants.NEW_FOLDER.value+"/"+this.name);
            File originalFile = new File(this.path);

            if(!newFolder.exists()){
                if(!newFolder.mkdirs()){
                    throw new Exception("Error creating new folder");
                }
            }
            if(!originalFile.renameTo(targetFile)) {
                throw  new Exception("Error moving file");
            }

        }catch (Exception e){
            throw new Exception("Excepcion : "+e.getMessage());
        }

    }


}
