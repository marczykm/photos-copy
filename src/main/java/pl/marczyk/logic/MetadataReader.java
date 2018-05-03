package pl.marczyk.logic;

import com.drew.imaging.ImageProcessingException;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public interface MetadataReader {
    void getAllTags(File file) throws ImageProcessingException, IOException;
    Date getDateFromMetadata(File file) throws ImageProcessingException, IOException;
}
