package com.example.demo.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-12 14:19
 */
public class FileUtil {
  public static void replaceText() {
    List<String> s1 = fileRead("/Users/huwenqi/Desktop/s1.txt");
    List<String> k1 = fileRead("/Users/huwenqi/Desktop/k1.txt");
    List<String> base = fileRead("/Users/huwenqi/Desktop/base.txt");
    for (int i = 0; i < base.size(); i++) {
      base.set(i, base.get(i).replace("%k%", s1.get(i)).replace("%s%", k1.get(i)));
    }
    fileOut(base, "/Users/huwenqi/Desktop/final.txt");
  }

  public static void main(String[] args) {
    //
    replaceText();
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
