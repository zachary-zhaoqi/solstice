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
import pers.zhaoqi.solstice.dictionary.dto.DataDictionaryTreeDTO;
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
        DataDictionary dataDictionary = new DataDictionary();
        BeanUtils.copyProperties(dataDictionaryInputDTO, dataDictionary);
        QueryWrapper queryWrapper = new QueryWrapper(dataDictionary);
        try {
            List<DataDictionary> list = dataDictionaryService.listObjs(queryWrapper);
            if (dataDictionaryInputDTO.isTree()) {
                return Result.success("返回查询到的树状数据", convertTree(list));
            } else {
                return Result.success("返回查询到的数据", list);
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return Result.failed(ConstantMessage.FAIL_CODE, "QueryDataDictionary查询出错；");
        }
    }

    /**
     * 根据传入的list转化为一个tree
     * todo
     *
     * @param dataDictionaryList
     * @return tree
     * @throws NullPointerException
     * @author 陈亮
     */
    public List convertTree(List<DataDictionary> dataDictionaryList) throws NullPointerException {
        if (dataDictionaryList == null || dataDictionaryList.size() == 0) {
            throw new NullPointerException("dataDictionaryList为空！");
        } else {
            DataDictionaryTreeDTO dataDictionaryTreeDTO =  new DataDictionaryTreeDTO();
            List<DataDictionaryTreeDTO> tree = new ArrayList<DataDictionaryTreeDTO>();
            for (DataDictionary dataDictionary :
                    dataDictionaryList) {
                if (dataDictionary.getParentId() == null) {
                    dataDictionaryTreeDTO.setDataDictionary(dataDictionary);
                    dataDictionaryTreeDTO.setTitle(dataDictionary.getLabelZhCn());
                    dataDictionaryTreeDTO.setValue(dataDictionary.getValue());
                    dataDictionaryTreeDTO.setKey(dataDictionary.getValue());
                    dataDictionaryTreeDTO.setChildren(getchlidren(dataDictionary.getId(),dataDictionaryList));
                    tree.add(dataDictionaryTreeDTO);
                    //tree.add(dataDictionary);
                }
            }
            return tree;
        }
    }

    public List getchlidren(Integer parentId,List<DataDictionary> dataDictionaryList){
        DataDictionaryTreeDTO dataDictionaryTreeDTO =  new DataDictionaryTreeDTO();
        List<DataDictionaryTreeDTO> children =  new ArrayList<DataDictionaryTreeDTO>();
        for (DataDictionary dataDictionary :
                dataDictionaryList) {
            if (dataDictionary.getParentId() == parentId) {
                dataDictionaryTreeDTO.setDataDictionary(dataDictionary);
                dataDictionaryTreeDTO.setTitle(dataDictionary.getLabelZhCn());
                dataDictionaryTreeDTO.setValue(dataDictionary.getValue());
                dataDictionaryTreeDTO.setKey(dataDictionary.getValue());
                dataDictionaryTreeDTO.setChildren(getchlidren(dataDictionary.getId(),dataDictionaryList));
                children.add(dataDictionaryTreeDTO);
                //tree.add(dataDictionary);
            }
        }
        return  children;
    }
}
