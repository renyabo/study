package org.yabo.utils.poi;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CloudKnowledgeExcelParser {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/yabo.ren/cloudKnowledge.xlsx");
        System.out.println(file.exists());
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getSheetName() + "---" + sheet.getFirstRowNum() + "----" + sheet.getLastRowNum());
        Iterator<Row> iterator = sheet.rowIterator();
        Row head = iterator.next();
        int standardIndex = -1;
        int similarStartIndex = -1;
        int similarEndIndex = -1;
        int industryIndex = -1;
        int categoryStart = -1;
        int categoryEnd = -1;
        Iterator<Cell> cellIterator = head.cellIterator();
        int i = 0;
        while (cellIterator.hasNext()) {
            Cell next = cellIterator.next();
            String value = next.getStringCellValue();
            if (value != null) {
                value = value.trim();
                if ("标准问题".equals(value)) {
                    standardIndex = i;
                } else if ("相似问题1".equals(value)) {
                    similarStartIndex = i;
                } else if ("行业".equals(value)) {
                    industryIndex = i;
                } else if ("一级分类".equals(value)) {
                    categoryStart = i;
                }
            }
            i++;
        }
        similarEndIndex = industryIndex - 1;
        categoryEnd = i;
        System.out.println("标准=" + standardIndex + "，相似Start=" + similarStartIndex + "，相似end=" + similarEndIndex + "，行业=" + industryIndex + "，分类start=" + categoryStart + "，分类end=" + categoryEnd);
        List<RowValues> rowValues = new ArrayList<>();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            RowValues values = RowValues.parse(row, standardIndex, similarStartIndex, similarEndIndex, industryIndex, categoryStart, categoryEnd);
            rowValues.add(values);
            System.out.println(values);
        }
        save(rowValues);
        workbook.close();
        //        Row row = Sheet.getRow(1);
//        Double value = row.getCell(1).getNumericCellValue();
//        System.out.println(value);
    }

    private static void save(List<RowValues> rowValues) throws Exception {
        File file = new File("/Users/yabo.ren/upload.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        creatCategory(workbook.createSheet("知识库五级分类"), getCategoryPath(rowValues));
        createKnowledge(workbook.createSheet("知识库"), rowValues);
        workbook.write(new FileOutputStream(file));
    }

    private static void createKnowledge(XSSFSheet sheet, List<RowValues> rowValues) {
        int maxSimilarLength = getSimilarMaxLength(rowValues);
        List<String> headerList = new ArrayList<>();
        headerList.add("标准问题");
        for (int i = 0; i <= maxSimilarLength; i++) {
            headerList.add("相似问法" + (i + 1));
        }
        headerList.add("一级行业");
//        headerList.add("二级行业");
        headerList.add("一级分类");
        headerList.add("二级分类");
        headerList.add("三级分类");
        headerList.add("四级分类");
        headerList.add("五级分类");
        System.out.println(headerList);
        int i = 0;
        Row row = sheet.createRow(i++);
        createCell(row, 0, toArray(headerList));
        for (RowValues value : rowValues) {
            row = sheet.createRow(i++);
            int j = 0;
            createCell(row, j++, value.standard);
            createCell(row, j, toArray(value.similars));
            j += maxSimilarLength;
            createCell(row, j++, value.industry);
            createCell(row, j, toArray(value.categories));
        }
    }

    private static String[] toArray(List<String> similars) {
        String[] array = new String[similars.size()];
        return similars.toArray(array);
    }

    private static int getSimilarMaxLength(List<RowValues> rowValues) {
        int maxLength = 0;
        for (RowValues row : rowValues) {
            maxLength = Math.max(maxLength, row.similars.size());
        }
        return maxLength;
    }

    private static void creatCategory(Sheet sheet, List<List<String>> categoryPath) {
        System.out.println(categoryPath);
        int i = 0;
        Row row = sheet.createRow(i++);
        createCell(row, 0, "一级类目", "二级类目", "三级类目", "四级类目", "五级类目");
        for (List<String> list : categoryPath) {
            row = sheet.createRow(i++);
            String[] strings = new String[list.size()];
            createCell(row, 0, list.toArray(strings));
        }
    }

    private static void createCell(Row row, int start, String... value) {
        for (int i = 0; i < value.length; i++) {
            Cell cell = row.createCell(start + i);
            cell.setCellValue(value[i]);
        }
    }

    private static List<List<String>> getCategoryPath(List<RowValues> rowValues) {
        final String split = "YABO";
        List<List<String>> res = new ArrayList<>();
        List<String> collect = rowValues.stream().map(value -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < value.categories.size() - 1; i++) {
                builder.append(value.categories.get(i)).append(split);
            }
            builder.append(value.categories.get(value.categories.size() - 1));
            return builder.toString();
        }).distinct().collect(Collectors.toList());
        collect.forEach(s -> {
            String[] strings = s.split(split);
            List<String> list = new ArrayList<>();
            for (String string : strings) {
                list.add(string);
            }
            if (CollectionUtils.isNotEmpty(list)) {
                res.add(list);
            }
        });
        return res;
    }

    static class RowValues {
        String standard;
        List<String> similars = new ArrayList<>();
        String industry;
        List<String> categories = new ArrayList<>();

        static RowValues parse(Row row, int standardIndex, int similarStartIndex, int similarEndIndex, int industryIndex, int categoryStart, int categoryEnd) {
            RowValues values = new RowValues();
            values.standard = row.getCell(standardIndex).getStringCellValue().trim();
            for (int i = similarStartIndex; i <= similarEndIndex; i++) {
                String stringCellValue = getCellValues(row.getCell(i));
                if (StringUtils.isNotBlank(stringCellValue)) {
                    values.similars.add(stringCellValue);
                }
            }
            values.industry = row.getCell(industryIndex).getStringCellValue();
            for (int i = categoryStart; i < categoryEnd; i++) {
                String stringCellValue = getCellValues(row.getCell(i));
                if (StringUtils.isNotBlank(stringCellValue)) {
                    values.categories.add(stringCellValue);
                }
            }
            return values;
        }

        private static String getCellValues(Cell cell) {
            if (cell == null) {
                return null;
            }
            return cell.getStringCellValue();
        }


        @Override
        public String toString() {
            return "RowValues{" +
                    "standard='" + standard + '\'' +
                    ", similars=" + similars +
                    ", industry='" + industry + '\'' +
                    ", categories=" + categories +
                    '}';
        }
    }
}
