package com.example.sample;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.univocity.parsers.tsv.TsvWriter;
import com.univocity.parsers.tsv.TsvWriterSettings;

import lombok.val;

public class TsvSample {

    public static void writeHeadersAndRows(String[] headers, List<Object[]> rows) {
        System.out.println("Tsv: writeHeadersAndRows");
        val result = new ByteArrayOutputStream();
        try (val outputWriter = new OutputStreamWriter(result);) {
            val writer = new TsvWriter(outputWriter, new TsvWriterSettings());
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
