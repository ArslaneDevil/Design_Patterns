package com.fges.todoapp.Storage.Csv;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TodoCsvList extends AbtractTodoCsvStorage{

    protected TodoCsvList(Path filePath) {
        super(filePath);
    }

    public void findAll(boolean onlyDone) throws IOException {
        String fileContent = "";

        if (Files.exists(filePath)) {
            fileContent = Files.readString(filePath);
        }
        Stream<String> lines = Arrays.stream(fileContent.split("\n"));
        if (onlyDone) {
            lines = lines.filter(line -> line.startsWith("Done: "));
        }
        System.out.println(lines.map(todo -> "- " + todo).collect(Collectors.joining("\n")));
    }
}
