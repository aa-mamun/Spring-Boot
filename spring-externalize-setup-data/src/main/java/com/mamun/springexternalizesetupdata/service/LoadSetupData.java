package com.mamun.springexternalizesetupdata.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.mamun.springexternalizesetupdata.domain.Role;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mapping.MappingException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@Service
public class LoadSetupData {
    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> it = mapper.readerFor(type).with(bootstrapSchema)
                    .readValues(file);
            return it.readAll();
        } catch (Exception e) {
            //logger.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }

    public List<String[]> loadManyToManyRelationship(String fileName) {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<String[]> readValues =
                    mapper.reader(String[].class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {

            return Collections.emptyList();
        }
    }


}
