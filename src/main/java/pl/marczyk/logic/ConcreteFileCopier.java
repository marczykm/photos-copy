package pl.marczyk.logic;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class ConcreteFileCopier implements FileCopier {

    public void copy(File from, File to) throws IOException {
        Files.copy(from, to);
    }
}
