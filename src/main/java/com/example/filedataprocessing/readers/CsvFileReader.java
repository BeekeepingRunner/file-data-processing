package com.example.filedataprocessing.readers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReader {

    public static <T> List<T> parseObjectsFrom(File file, Class<T> resultObjectClass) {
        try (Reader reader = Files.newBufferedReader(file.toPath())) {
            CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
                    .withType(resultObjectClass)
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .build();

            return cb.parse();
        } catch (IOException e) {
            throw new RuntimeException("Cannot parse object from .csv file", e);
        }
    }

}
