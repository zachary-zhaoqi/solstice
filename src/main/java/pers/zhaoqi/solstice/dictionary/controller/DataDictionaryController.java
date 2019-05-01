package pers.zhaoqi.solstice.dictionary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.dictionary.dto.DataDictionaryInputDTO;
import pers.zhaoqi.solstice.dictionary.entity.DataDictionary;
import pers.zhaoqi.solstice.dictionary.service.IDataDictionaryService;

import javax.swing.*;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/dictionary/dataDictionary")
public class DataDictionaryController {

    @Autowired
    private IDataDictionaryService dataDictionaryService;

    @GetMapping()
    public ActionResult QueryDataDictionary(DataDictionaryInputDTO dataDictionaryInputDTO) {
        return null;
    }
}
