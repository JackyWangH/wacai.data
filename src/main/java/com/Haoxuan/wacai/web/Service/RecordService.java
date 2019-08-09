package com.Haoxuan.wacai.web.Service;

import com.Haoxuan.wacai.web.Model.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecordService {
        //读取excel中的数据
        public Map<String, User> query() {
            File file = new File("./port.xlsx");
            Map<String, User> records = new HashMap<>();
            //如果文件不存在直接返回数据
            if (!file.exists()){
                return records;
            }
            try {
                Workbook wb = new XSSFWorkbook(file);
                Sheet sheet = wb.getSheetAt(0);
                int rows = sheet.getPhysicalNumberOfRows();
                for(int i = 1; i<rows; i++){//遍历Excel行，每行添加数据
                    Row row = sheet.getRow(i);//第几行
                    for(Cell cell : row){//每个单元格设置为String类型数据
                        cell.setCellType(CellType.STRING);
                    }
                    User record = new User();//创建一个User对象
                    record.setPort(row.getCell(0).getStringCellValue());//端口号放第一列
                    record.setPassword(row.getCell(1).getStringCellValue());//密码第二列
                    record.setName(row.getCell(2).getStringCellValue());//姓名第三列
                    record.setPhone(row.getCell(3).getStringCellValue());//手机号第四列
                    records.put(record.getPhone(),record);//手机号为Key值，为Hashmap查询方式，Value为record记录
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
            return records;//将hashmap里存的数据返回
        }
    }
