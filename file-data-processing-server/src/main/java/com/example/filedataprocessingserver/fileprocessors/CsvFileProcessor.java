package com.example.filedataprocessingserver.fileprocessors;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.util.List;

public class CsvFileProcessor {

    public static <T> List<T> parseObjectsFrom(File file, Class<T> resultObjectClass) {
        try (Reader reader = Files.newBufferedReader(file.toPath())) {
            return new CsvToBeanBuilder<T>(reader)
                    .withType(resultObjectClass)
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new RuntimeException("Cannot parse object from .csv file", e);
        }
    }

    public static <T> void saveCsvFile(File file, List<T> csvRowElements) {
        try (Writer writer = Files.newBufferedWriter(file.toPath())) {
            new StatefulBeanToCsvBuilder<T>(writer)
                    .withSeparator(';')
                    .withApplyQuotesToAll(false)
                    .build()
                    .write(csvRowElements);
        } catch (IOException e) {
            throw new RuntimeException("Cannot save .csv file from data object", e);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }
}