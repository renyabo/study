package org.yabo.wife;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Antibacterial {

    static SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    static File PATH = new File("D:" + File.separator + "min");
    static final int MAX = 100;
    static final String mz1 = "mz1.xlsx";
    static final String mz2 = "mz2.xlsx";
    static final String jz1 = "jz1.xlsx";
    static final String jz2 = "jz2.xlsx";
    static Map<String, Set<String>> level = MedicineLevelUtil.getMedicineLevel();

    public static void main(String[] args) throws Exception {
        File[] files = PATH.listFiles();
        Map<String, File> fileMap = new HashMap<>();
        if (files != null && files.length > 0) {
            for (File file : files) {
                fileMap.put(file.getName(), file);
            }
        }
        dealOutpatient(fileMap.get(mz1), fileMap.get(mz2));
        dealEmergency(fileMap.get(jz1), fileMap.get(jz2));
    }

    private static void dealEmergency(File source, File merge) throws Exception {
        List<Row> sourceRows = getRowsFromWorkbook(source);
        Row sourceTitle = sourceRows.remove(0);
        int size = sourceRows.size();
        sourceRows = sample(sourceRows);
        List<Row> rowsForMerge = getRowsFromWorkbook(merge);
        Row mergeTitle = rowsForMerge.remove(0);
        Map<String, List<Row>> map = new HashMap<>();
        sourceRows.forEach(row -> map.put(row.getCell(3).getStringCellValue(), new ArrayList<>()));
        rowsForMerge.forEach(row -> {
            List<Row> rows = map.get(row.getCell(4).getStringCellValue());
            if (rows != null) {
                rows.add(row);
            }
        });
        Workbook workbook = make(size, sourceTitle, mergeTitle, sourceRows, map);
        saveWorkBook(workbook, "急诊结果汇总.xls");
    }

    private static void dealOutpatient(File source, File merge) throws Exception {
        List<Row> sourceRows = getRowsFromWorkbook(source);
        Row sourceTitle = sourceRows.remove(0);
        sourceRows = sourceRows.stream().filter(row -> {
            Cell cell = row.getCell(5);
            double age = cell.getNumericCellValue();
            return age >= 16;
        }).collect(Collectors.toList());
        int filterSize = sourceRows.size();
        System.out.println(filterSize);
        sourceRows = sample(sourceRows);
        List<Row> rowsForMerge = getRowsFromWorkbook(merge);
        Row mergeTitle = rowsForMerge.remove(0);
        Map<String, List<Row>> map = new HashMap<>();
        sourceRows.forEach(row -> map.put(row.getCell(3).getStringCellValue(), new ArrayList<>()));
        rowsForMerge.forEach(row -> {
            List<Row> rows = map.get(row.getCell(4).getStringCellValue());
            if (rows != null) {
                rows.add(row);
            }
        });
        Workbook workbook = make(filterSize, sourceTitle, mergeTitle, sourceRows, map);
        saveWorkBook(workbook, "门诊结果汇总.xls");
    }

    private static void saveWorkBook(Workbook workbook, String name) throws Exception {
        FileOutputStream out = new FileOutputStream(PATH.getPath() + File.separator + name);
        workbook.write(out);
        out.close();
    }

    private static Workbook make(int size, Row sourceTitle, Row mergeTitle, List<Row> sourceRows, Map<String, List<Row>> map) {
        Workbook workbook = new HSSFWorkbook();
        Sheet saveSheet = workbook.createSheet("汇总");
        int i = 0;
        Row totle = saveSheet.createRow(i++);
        Cell totleCell = totle.createCell(0);
        totleCell.setCellType(CellType.NUMERIC);
        totleCell.setCellValue(size);
        Row title = saveSheet.createRow(i++);
        int titleCellIndex = 0;
        int seq = 1;
        Cell sequence = title.createCell(titleCellIndex++);
        sequence.setCellType(CellType.STRING);
        sequence.setCellValue("序号");
        for (int j = 2; j < sourceTitle.getLastCellNum(); j++) {
            copyTo(sourceTitle.getCell(j), title.createCell(titleCellIndex++));
        }
        for (int j = 10; j < mergeTitle.getLastCellNum(); j++) {
            copyTo(mergeTitle.getCell(j), title.createCell(titleCellIndex++));
        }
        Cell level = title.createCell(titleCellIndex++);
        level.setCellType(CellType.STRING);
        level.setCellValue("级别");
        for (Row row : sourceRows) {
            List<Row> mergeRows = map.get(row.getCell(3).getStringCellValue());
            if (mergeRows != null && !mergeRows.isEmpty()) {
                for (Row mRow : mergeRows) {
                    Row saveRow = saveSheet.createRow(i++);
                    int cellIndex = 0;
                    sequence = saveRow.createCell(cellIndex++);
                    sequence.setCellType(CellType.NUMERIC);
                    sequence.setCellValue(seq);
                    for (int k = 2; k < row.getLastCellNum(); k++) {
                        copyTo(row.getCell(k), saveRow.createCell(cellIndex++));
                    }
                    for (int k = 10; k < mRow.getLastCellNum(); k++) {
                        copyTo(mRow.getCell(k), saveRow.createCell(cellIndex++));
                    }
                    saveMedicineLevel(mRow.getCell(10).getStringCellValue(), saveRow.createCell(cellIndex++));
                }
                seq++;
            } else {
                Row saveRow = saveSheet.createRow(i++);
                int cellIndex = 0;
                sequence = saveRow.createCell(cellIndex++);
                sequence.setCellType(CellType.NUMERIC);
                sequence.setCellValue(seq++);
                for (int k = 2; k < row.getLastCellNum(); k++) {
                    copyTo(row.getCell(k), saveRow.createCell(cellIndex++));
                }
            }
        }
        return workbook;
    }

    private static void saveMedicineLevel(String medical, Cell cell) {
        cell.setCellType(CellType.STRING);
        for (String key : level.keySet()) {
            Set<String> medicals = level.get(key);
            for (String m : medicals) {
                if (medical.contains(m)) {
                    cell.setCellValue(key);
                    return;
                }
            }
        }
    }


    //抽样
    private static List<Row> sample(List<Row> rows) {
        if (rows.size() > MAX) {
            int step = rows.size() / MAX;
            Random random = new Random();
            int start = random.nextInt(step);
            start++;
            System.out.println("start=" + start + ",step=" + step);
            List<Row> filter = new ArrayList<>();
            while (start < rows.size() && filter.size() < MAX) {
                filter.add(rows.get(start));
                start += step;
            }
            return filter;
        }
        return rows;
    }

    private static void print(List<Row> rows) {
        rows.forEach(row -> {
            System.out.println();
            row.cellIterator().forEachRemaining(cell -> {
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Date date = cell.getDateCellValue();
                            System.out.print(FORMATTER.format(date));
                        } else {
                            System.out.print(cell.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    default:
                        System.out.print("");
                }
                System.out.print(" ");
            });
        });
    }

    private static List<Row> getRowsFromWorkbook(File source) throws Exception {
        Workbook workbook = WorkbookFactory.create(source);
        List<Row> rows = new ArrayList<>();
        workbook.getSheetAt(0).forEach(rows::add);
        return rows;
    }

    private static void copyTo(Row from, Row to) {
        int index = 0;
        Iterator<Cell> cellIterator = from.cellIterator();
        while (cellIterator.hasNext()) {
            Cell fromCell = cellIterator.next();
            Cell toCell = to.createCell(index++);
            copyTo(fromCell, toCell);
        }
    }

    private static void copyTo(Cell fromCell, Cell toCell) {
        toCell.setCellType(fromCell.getCellType());
        switch (fromCell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                toCell.setCellValue(fromCell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(fromCell)) {
                    toCell.setCellType(Cell.CELL_TYPE_STRING);
                    Date date = fromCell.getDateCellValue();
                    toCell.setCellValue(FORMATTER.format(date));
                } else {
                    toCell.setCellValue(fromCell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                toCell.setCellValue(fromCell.getBooleanCellValue());
                break;
            default:
                toCell.setCellValue("");
        }
    }
}
