package pl.marczyk.service;

import com.drew.imaging.ImageProcessingException;
import org.apache.commons.io.FilenameUtils;
import pl.marczyk.logic.FilesRetriever;
import pl.marczyk.logic.MetadataReader;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PhotoCopyService {

    private final MetadataReader metadataReader;

    @Inject
    PhotoCopyService(MetadataReader metadataReader){
        this.metadataReader = metadataReader;
    }

    public void process(File directory) throws ImageProcessingException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfToSave = new SimpleDateFormat("yyyyMMdd_HHmmss");
        List<File> filesInDirectory = FilesRetriever.getFilesInDirectory(directory);
        for (File file : filesInDirectory) {
            System.out.format("[%s] - %s - %s\n",
                    file.getName(),
                    sdf.format(metadataReader.getDateFromMetadata(file)),
                    sdfToSave.format(metadataReader.getDateFromMetadata(file)) + "." + FilenameUtils.getExtension(file.getName())
            );
        }
    }
}
