package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {
  public static List<List<String>> parseCsvIntoList(String filePath, String delimiter) {
    String line;
    List<List<String>> data = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(filePath), Charset.forName("UTF-8")))) {
      while ((line = br.readLine()) != null)
        data.add(Arrays.asList(line.replace("\"", "").split(delimiter)));

      return data;
    } catch (Exception e) {
      throw new RuntimeException("Houve um erro ao converter seu arquivo CSV para List:\n" + e.getMessage());
    }
  }
}
