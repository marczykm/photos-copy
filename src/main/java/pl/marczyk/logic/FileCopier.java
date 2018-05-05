package pl.marczyk.logic;

import java.io.File;
import java.io.IOException;

public interface FileCopier {

    void copy(File from, File to) throws IOException;

}
