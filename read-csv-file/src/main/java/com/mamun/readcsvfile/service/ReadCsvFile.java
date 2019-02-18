package com.mamun.readcsvfile.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.mamun.readcsvfile.domain.Role;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Service
public class ReadCsvFile {
    public List<Role> readData(String nameOfCsvFile) {
        try {
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(nameOfCsvFile).getFile();
            MappingIterator<Role> mappingIterator = mapper.readerFor(Role.class).with(csvSchema)
                    .readValues(file);
            return mappingIterator.readAll();
        } catch (Exception e) {

            return Collections.emptyList();
        }
    }


}
