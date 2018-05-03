package pl.marczyk.logic;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ConcreteMetadataReader  implements MetadataReader {

    public void getAllTags(File file) throws ImageProcessingException, IOException {
        Metadata metadata = ImageMetadataReader.readMetadata(file);

        for (Directory directory : metadata.getDirectories()){
            for (Tag tag : directory.getTags()){
                System.out.format("[%s] - %s = %s\n",
                        directory.getName(), tag.getTagName(), tag.getDescription());
            }
            if (directory.hasErrors()){
                for (String error : directory.getErrors()){
                    System.err.format("ERROR: %s", error);
                }
            }
        }
    }

    public Date getDateFromMetadata(File file) throws ImageProcessingException, IOException {
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
        return directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
    }

}
