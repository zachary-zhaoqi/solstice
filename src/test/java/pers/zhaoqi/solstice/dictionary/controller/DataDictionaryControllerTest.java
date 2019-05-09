package pers.zhaoqi.solstice.dictionary.controller;

import org.junit.Test;
import pers.zhaoqi.solstice.dictionary.dto.DataDictionaryInputDTO;
import pers.zhaoqi.solstice.dictionary.dto.DataDictionaryTreeDTO;
import pers.zhaoqi.solstice.dictionary.entity.DataDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class DataDictionaryControllerTest {

    @Test
    public void queryDataDictionary() {
        DataDictionaryInputDTO dataDictionaryInputDTO=new DataDictionaryInputDTO();
        dataDictionaryInputDTO.setKey("category");
        DataDictionaryController dataDictionaryController=new DataDictionaryController();
        dataDictionaryController.QueryDataDictionary(dataDictionaryInputDTO);
    }

    @Test
    public void creatTree() {
        List<DataDictionary> dataDictionaryList = new ArrayList<DataDictionary>();
        DataDictionary dataDictionary = new DataDictionary();
        Random r = new Random(1000);
        for (Integer i = 1;i<10;i++)
        {
            dataDictionary.setLabelZhCn("LabelZhCn" + i);
            dataDictionary.setValue("Value" + i);
            dataDictionary.setId(i);
            Integer parentid = r.nextInt(i)-1;
            if (parentid <= 0) {
                dataDictionary.setParentId(null);
            }else {
                dataDictionary.setParentId(parentid);
            }
            dataDictionaryList.add(dataDictionary);
        }
        DataDictionaryController dataDictionaryController=new DataDictionaryController();
        dataDictionaryController.convertTree(dataDictionaryList);
        System.out.println("测试完成");
    }
}