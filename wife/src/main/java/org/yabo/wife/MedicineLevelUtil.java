package org.yabo.wife;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MedicineLevelUtil {

    public static Map<String, Set<String>> getMedicineLevel() {
        File[] files = Antibacterial.PATH.listFiles();
        Map<String, Set<String>> map = new HashMap<>();
        Arrays.stream(files).forEach(file -> {
            switch (file.getName()) {
                case "feixianzhi.txt":
                    map.put("非限制", loadData(file));
                    break;
                case "xianzhi.txt":
                    map.put("限制", loadData(file));
                    break;
                case "teshu.txt":
                    map.put("特殊", loadData(file));
                    break;
                default:
                    break;
            }
        });
        return map;
    }

    private static Set<String> loadData(File file) {
        Set<String> set = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = br.readLine()) != null && StringUtils.isNotBlank(line)) {
                set.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Set<String>> medicineLevel = getMedicineLevel();
        for (Set<String> value : medicineLevel.values()) {
            System.out.println(value.size());
        }
    }
}
