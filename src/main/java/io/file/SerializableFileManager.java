package io.file;

import exception.DataExportException;
import exception.DataImportException;
import model.Library;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "Libraty.o";

    @Override
    public Library importDate() {
        try (
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd zapisu danych do pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny tym danych w pliku " + FILE_NAME);
        }
    }

    @Override
    public void exportData(Library library) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }
}
