package pl.marczyk.configuration;

import com.google.inject.AbstractModule;
import pl.marczyk.logic.ConcreteFileCopier;
import pl.marczyk.logic.ConcreteMetadataReader;
import pl.marczyk.logic.FileCopier;
import pl.marczyk.logic.MetadataReader;

public class PhotoCopyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MetadataReader.class).to(ConcreteMetadataReader.class);
        bind(FileCopier.class).to(ConcreteFileCopier.class);
    }
}
