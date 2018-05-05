package pl.marczyk.service;

import com.drew.imaging.ImageProcessingException;
import com.google.common.io.Files;
import com.sun.xml.internal.ws.util.StringUtils;
import org.apache.commons.io.FilenameUtils;
import pl.marczyk.logic.FileCopier;
import pl.marczyk.logic.FilesRetriever;
import pl.marczyk.logic.MetadataReader;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

public class PhotoCopyService {

//    private final Logger logger

    private final String destination = "/media/marcin/XfsVolume/zdj/";

    private final MetadataReader metadataReader;
    private final FileCopier fileCopier;

    @Inject
    PhotoCopyService(MetadataReader metadataReader, FileCopier fileCopier){
        this.metadataReader = metadataReader;
        this.fileCopier = fileCopier;
    }

    public void process(File directory) throws ImageProcessingException, IOException {
        List<File> filesInDirectory = FilesRetriever.getFilesInDirectory(directory);
        for (File file : filesInDirectory) {
                    fileCopier.copy(file,
                            new File(buildNewFilename(file)
                            ));
        }
    }

    private String buildNewFilename(File file) throws ImageProcessingException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfToSave = new SimpleDateFormat("yyyyMMdd_HHmmss");
        System.out.format("[%s] - %s - %s\n",
                file.getName(),
                sdf.format(metadataReader.getDateFromMetadata(file)),
                sdfToSave.format(metadataReader.getDateFromMetadata(file)) + "." + FilenameUtils.getExtension(file.getName()));
        return FilenameUtils.separatorsToSystem(
                destination +
                        "/" +
                        sdfToSave.format(metadataReader.getDateFromMetadata(file))
                + "." + FilenameUtils.getExtension(file.getName()));
    }
}
