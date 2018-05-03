package pl.marczyk;

import com.drew.imaging.ImageProcessingException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import pl.marczyk.configuration.PhotoCopyModule;
import pl.marczyk.service.PhotoCopyService;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ImageProcessingException, IOException {
        Injector injector = Guice.createInjector(new PhotoCopyModule());
        PhotoCopyService photoCopyService = injector.getInstance(PhotoCopyService.class);

        photoCopyService.process(new File(args[0]));
    }
}
