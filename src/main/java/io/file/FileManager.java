package io.file;

import model.Library;

public interface FileManager {
    Library importDate();
    void exportData(Library library);
}
