package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExcelUtility {


    private static String path = "test-output/outputs/";
    private static String fileName = "excelLog1.xlsx";
    private static String pathAndFileName = path + fileName;
    private static XSSFWorkbook xssfWorkbook;
    private static Workbook workbook;
    private static XSSFSheet xssfSheet;
    private static Sheet sheet;
    private static Sheet activeSheet;
    private static String sheetname1 = "Sheet_1";
    private static FileInputStream input;
    private static FileOutputStream output;
    static boolean fileExists;


    public ExcelUtility() {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

    }

    public static void createData(){

        createExcelFile();
        createExcelSheet("Sayfa1");
        setActiveSheet("Sayfa1");

    }

    public static void saveData(){
        saveExcel();
        closeWorkbook();
    }

    public static void createExcelFile() {
        File path = new File(pathAndFileName);
        if (!path.exists()) {
            xssfWorkbook = new XSSFWorkbook();
            try {
                output = new FileOutputStream(pathAndFileName);
                fileExists = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            fileExists = true;
            try {
                input = new FileInputStream(pathAndFileName);
                workbook = WorkbookFactory.create(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void createExcelSheet(String... sheets) {
        if (!fileExists) {
            for (String sheet1 : sheets) {
                xssfWorkbook.createSheet(sheet1);
            }

        }

    }

    public static void setActiveSheet(String sheetName2) {
        if (!fileExists) {
            activeSheet = xssfWorkbook.getSheet(sheetName2);
        } else
            activeSheet = workbook.getSheet(sheetName2);

    }

    public static void writeHeader(List<String> header) {
        Row row = activeSheet.createRow(0);
        for (int i = 0; i < header.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(header.get(i));
        }

    }


    public static String getCurrentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }

    public static void writeDataList(List<String> data) {
        if (!fileExists) {
            Row row = activeSheet.createRow(1);
            for (int j = 0; j < data.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data.get(j));
            }



        } else {
            int actualRowCount = activeSheet.getLastRowNum();
            Row row = activeSheet.createRow(actualRowCount + 2);
            for (int j = 0; j < data.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data.get(j));
            }

        }


    }

    public static void writeData(List<List<String>> listofDataList) {
        if (!fileExists) {
            for (int i = 1; i <= listofDataList.size(); i++) {
                Row row = activeSheet.createRow(i);
                for (int j = 0; j < listofDataList.get(i - 1).size(); j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(listofDataList.get(i - 1).get(j));
                }

            }
        } else {
            int actualRowCount = activeSheet.getLastRowNum();
            for (int i = 1; i < listofDataList.size() + 1; i++) {
                Row row = activeSheet.createRow(i + actualRowCount + 1);
                for (int j = 0; j < listofDataList.get(i - 1).size(); j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(listofDataList.get(i - 1).get(j));
                }
            }

        }


    }

    public static void saveExcel() {
        if (!fileExists) {
            try {
                xssfWorkbook.write(output);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                input.close();
                output = new FileOutputStream(pathAndFileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void closeWorkbook() {

        if (!fileExists) {
            try {
                xssfWorkbook.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {

                workbook.write(output);
                workbook.close();
                output.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void readExcelFile(String filePath, String sheetName3) {
        List<List<String>> listofDataList = new LinkedList<>();

        try {
            input = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        activeSheet = workbook.getSheet(sheetName3);
        int rowCount = activeSheet.getLastRowNum();
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = activeSheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum() + 1; j++) {
                Cell cell = row.getCell(j);
                listofDataList.get(i).add(cell.toString());
            }
        }
    }

    public static List<List<String>> getDataAsList(String filePath, String sheetName3) {

        List<List<String>> listofDataList = new LinkedList<>();

        try {
            input = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        activeSheet = workbook.getSheet(sheetName3);
        int rowCount = activeSheet.getLastRowNum();

        for (int i = 0; i < rowCount + 1; i++) {
            Row row = activeSheet.getRow(i);
            List<String> rows = new LinkedList<>();
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum() + 1; j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = cell == null ? "" : cell.toString();
                    rows.add(cellValue);
                }
            } else {
                System.out.println(" ");
            }


            listofDataList.add(rows);
        }

        return listofDataList;
    }

    public static List<Map<String,List<String>>> getDataAsMap(String filePath, String sheetName3) {

        List<Map<String, List<String>>> listOfMaps = new LinkedList<>();
        try {
            input = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        activeSheet = workbook.getSheet(sheetName3);

        Map<String, List<String>> header = new LinkedHashMap<>();

        List<String> listHeader = new LinkedList<>();
        Row headerRow = activeSheet.getRow(0);
        // listHeader.add(headerRow.getCell(0).toString());
        listHeader.add(headerRow.getCell(1).toString() + "\t");
        listHeader.add(headerRow.getCell(2).toString() + "\t");
        listHeader.add(headerRow.getCell(3).toString() + "\t");
        header.put("Sıra No" + "\t", listHeader);
        listOfMaps.add(header);   // başlığı ekledik

        int rowCount = activeSheet.getLastRowNum();

        for (int i = 1; i < rowCount; i++) {
            Map<String, List<String>> rowMap = new LinkedHashMap<>();
            Row row = activeSheet.getRow(i);
            int cellCount = row.getLastCellNum();
            List<String> listOfData = new LinkedList<>();
            Cell cellFirst = row.getCell(0);
            for (int j = 1; j < cellCount; j++) {
                Cell cell = row.getCell(j);
                listOfData.add(cell.toString());
                rowMap.put(cellFirst.toString().substring(0, 1) + "\t", listOfData);
            }

            listOfMaps.add(rowMap);
        }

        return listOfMaps;
    }


    public static List<Map<String,Map<List<String>,List<String>>>> getDataAsListOfMap(String filePath, String sheetName3){

        List<Map<String,Map<List<String>,List<String>>>> listOfMaps = new LinkedList<>();
        //  Key1:SıraNo,Val1:(Key2:HeaderList,Val2:SatırIcerigiList)

        try {
            input = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        activeSheet = workbook.getSheet(sheetName3);

        List<String> headerList = new LinkedList<>();
        Row headerRow = activeSheet.getRow(0);

        for (int i = 1 ; i < headerRow.getLastCellNum(); i++) {
            headerList.add(headerRow.getCell(i).toString() + "\t");
        }

        int rowCount = activeSheet.getLastRowNum();

        for (int i = 1; i < rowCount; i++) {
            Row row = activeSheet.getRow(i);
            int cellCount = row.getLastCellNum();
            Map<String,Map<List<String>,List<String>>> mapwithRowNumber  = new LinkedHashMap<>();
            Map<List<String>,List<String>> headerAndRowMaps =new LinkedHashMap<>();
            List<String> listOfData = new LinkedList<>();
            Cell cellRowNumber = row.getCell(0);
            for (int j = 1; j < cellCount; j++) {
                Cell cell = row.getCell(j);
                listOfData.add(cell.toString());
            }
            headerAndRowMaps.put(headerList,listOfData);
            mapwithRowNumber.put(cellRowNumber.toString(),headerAndRowMaps);
            listOfMaps.add(mapwithRowNumber);
        }

        return listOfMaps;
    }


}




