package com.example.demo.util;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-12 14:19
 */
public class FileUtil {

  public void readAllBytes() throws IOException {
    File file = new File("fileName");
    String content = new String(Files.readAllBytes(file.toPath()));

    List<String> lines = Files.readAllLines(file.toPath());

    try (Stream<String> lineStream = Files.lines(file.toPath())) {
      // xxx 惰性读取文件
    }
  }

  public static void replaceText() {
    List<String> s1 = fileRead("/Users/huwenqi/Desktop/s1.txt");
    List<String> k1 = fileRead("/Users/huwenqi/Desktop/k1.txt");
    List<String> base = fileRead("/Users/huwenqi/Desktop/base.txt");
    for (int i = 0; i < base.size(); i++) {
      base.set(i, base.get(i).replace("%k%", s1.get(i)).replace("%s%", k1.get(i)));
    }
    fileOut(base, "/Users/huwenqi/Desktop/final.txt");
  }

  //  public static void main(String[] args) {
  //    //
  //    replaceText();
  //  }
  public static void main(String[] args) {
    for (int i = 1; i < 2; ++i) {
      System.out.println(i);
    }
  }

  public static List<String> fileRead(String fileName) {
    List<String> list = new ArrayList<>();
    try {
      //            File file = new File(fileName);
      //            InputStreamReader inputReader = new InputStreamReader(new
      // FileInputStream(file));
      //            BufferedReader bufferedReader = new BufferedReader(inputReader);

      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String str;
      while ((str = bufferedReader.readLine()) != null) {
        list.add(str);
      }
      fileReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public static void fileOut(List list, String fileName) {
    try {
      File file = new File(fileName);
      file.createNewFile(); // 创建文件若存在直接覆盖
      FileWriter fileWriter = new FileWriter(file);
      BufferedWriter bufferedWriter = new BufferedWriter((fileWriter));
      list.forEach(
          line -> {
            try {
              bufferedWriter.write(line + "\r\n"); // \r\n换行
            } catch (IOException e) {
              e.printStackTrace();
            }
          });
      bufferedWriter.flush(); // 把缓冲区内容压入文件
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
