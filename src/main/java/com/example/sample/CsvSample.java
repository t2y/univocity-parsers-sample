package com.example.sample;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

import lombok.val;

public class CsvSample {

    public static void writeHeadersAndRows(String[] headers, List<Object[]> rows) {
        System.out.println("Csv: writeHeadersAndRows");
        val result = new ByteArrayOutputStream();
        try (val outputWriter = new OutputStreamWriter(result);) {
            val writer = new CsvWriter(outputWriter, new CsvWriterSettings());
            try {
                writer.writeHeaders(headers);
                for (val row : rows) {
                    writer.writeRow(row);
                }
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
    }
}
