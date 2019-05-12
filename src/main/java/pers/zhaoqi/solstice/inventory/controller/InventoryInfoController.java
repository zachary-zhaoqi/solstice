package pers.zhaoqi.solstice.inventory.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.enums.ResultCodeAndMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.inventory.dto.InventoryInfoInputDTO;
import pers.zhaoqi.solstice.inventory.dto.InventoryInfoOutputDTO;
import pers.zhaoqi.solstice.inventory.entity.InventoryInfo;
import pers.zhaoqi.solstice.inventory.service.IInventoryInfoService;
import pers.zhaoqi.solstice.product.entity.ProductInfo;
import pers.zhaoqi.solstice.product.service.IProductInfoService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static pers.zhaoqi.solstice.product.controller.ProductInfoController.MESSAGE_HEAD;

/**
 * <p>
 * 库存表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/inventory/inventoryInfo")
public class InventoryInfoController {
    Logger logger= LoggerFactory.getLogger(ProductInfo.class);
    @Autowired
    private IProductInfoService productInfoService;

    private IInventoryInfoService inventoryInfoService;
    /**
     * @author zhaoqi
     * @param inventoryInfoInputDTO
     * @return
     */
    @GetMapping
    public ActionResult queryInventoryInfo(@RequestBody InventoryInfoInputDTO inventoryInfoInputDTO) {
        try {
            ProductInfo productInfo = new ProductInfo();
            BeanUtils.copyProperties(inventoryInfoInputDTO, productInfo);
            QueryWrapper queryWrapper = new QueryWrapper(productInfo);
            if (inventoryInfoInputDTO.getCreatTimeRange().size() != 0){
                queryWrapper.between("modifyTime",inventoryInfoInputDTO.getCreatTimeRange().get(0),inventoryInfoInputDTO.getCreatTimeRange().get(1));
            }
            List<ProductInfo> productInfoList = productInfoService.list(queryWrapper);
            List<InventoryInfoOutputDTO> inventoryInfoOutputDTOS = new ArrayList<InventoryInfoOutputDTO>();
            if (productInfoList != null) {
                for (ProductInfo productInfo1:productInfoList
                     ) {
                    InventoryInfo inventoryInfo = new InventoryInfo();
                    BeanUtils.copyProperties(productInfo1,inventoryInfo);
                    QueryWrapper queryWrapper1 = new QueryWrapper(inventoryInfo);
                    List<InventoryInfo> inventoryInfoList = inventoryInfoService.list(queryWrapper1);
                    InventoryInfoOutputDTO inventoryInfoOutputDTO = new InventoryInfoOutputDTO();
                    for (InventoryInfo inven:inventoryInfoList
                         ) {
                        BeanUtils.copyProperties(inven,productInfo1);
                        BeanUtils.copyProperties(inven,inventoryInfoOutputDTO);
                        inventoryInfoOutputDTOS.add(inventoryInfoOutputDTO);
                    }
                }
                return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SUCCESS_QUERY_MESSAGE, inventoryInfoOutputDTOS);
            } else {
                return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SELECT_NULL, productInfoList);
            }
        } catch (Exception e) {
            logger.debug(MESSAGE_HEAD + "queryProduct" + e.getMessage());
            return Result.failed(ResultCodeAndMessage.FAIL_QUERY, MESSAGE_HEAD + ResultCodeAndMessage.FAIL_QUERY_MESSAGE);
        }
    }
}
