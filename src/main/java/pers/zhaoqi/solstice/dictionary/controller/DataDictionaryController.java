package pers.zhaoqi.solstice.dictionary.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.source.tree.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.enums.ConstantMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.dictionary.dto.DataDictionaryInputDTO;
import pers.zhaoqi.solstice.dictionary.entity.DataDictionary;
import pers.zhaoqi.solstice.dictionary.service.IDataDictionaryService;
import pers.zhaoqi.solstice.userlogin.service.IUserLoginService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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

    Logger logger = LoggerFactory.getLogger(DataDictionaryController.class);
    @Autowired
    private IDataDictionaryService dataDictionaryService;

    @GetMapping()
    public ActionResult QueryDataDictionary(DataDictionaryInputDTO dataDictionaryInputDTO) {
//        todo:if (dataDictionaryInputDTO==null)
        DataDictionary dataDictionary = new DataDictionary();
        BeanUtils.copyProperties(dataDictionaryInputDTO, dataDictionary);
        QueryWrapper queryWrapper = new QueryWrapper(dataDictionary);
        List<DataDictionary> list = null;
        try {
            list = dataDictionaryService.listObjs(queryWrapper);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return Result.failed(-500, "QueryDataDictionary查询出错；");
        }
        if (dataDictionaryInputDTO.isTree()) {
            return Result.success("查询成功", CreatTree(list));
        } else {
            return Result.success("查询成功", list);
        }
    }

    /**
     * 根据传入的list生成一个tree
     * todo
     *
     * @param dataDictionaryList
     * @return tree
     * @throws NullPointerException
     * @author 陈亮
     */
    public List CreatTree(List<DataDictionary> dataDictionaryList) throws NullPointerException {
        if (dataDictionaryList == null || dataDictionaryList.size() == 0) {
            throw new NullPointerException("dataDictionaryList为空！");
        } else {
            List<DataDictionary> tree = new ArrayList<DataDictionary>();
            for (DataDictionary dataDictionary :
                    dataDictionaryList) {
                if (dataDictionary.getParentId() == null) {
                    tree.add(dataDictionary);
                }
            }
            return tree;
        }
    }
}
