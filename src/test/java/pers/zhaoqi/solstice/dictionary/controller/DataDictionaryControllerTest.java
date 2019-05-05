package pers.zhaoqi.solstice.dictionary.controller;

import org.junit.Test;
import pers.zhaoqi.solstice.dictionary.dto.DataDictionaryInputDTO;

import static org.junit.Assert.*;

public class DataDictionaryControllerTest {

    @Test
    public void queryDataDictionary() {
        DataDictionaryInputDTO dataDictionaryInputDTO=new DataDictionaryInputDTO();
        dataDictionaryInputDTO.setKey("category");
        DataDictionaryController dataDictionaryController=new DataDictionaryController();
        dataDictionaryController.QueryDataDictionary(dataDictionaryInputDTO);
    }
}