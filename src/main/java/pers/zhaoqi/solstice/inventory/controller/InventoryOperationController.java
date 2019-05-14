package pers.zhaoqi.solstice.inventory.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.enums.ResultCodeAndMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.common.utils.Utils;
import pers.zhaoqi.solstice.inventory.dto.InventoryInfoInputDTO;
import pers.zhaoqi.solstice.inventory.dto.InventoryOperationInputDTO;
import pers.zhaoqi.solstice.inventory.entity.InventoryInfo;
import pers.zhaoqi.solstice.inventory.entity.InventoryOperation;
import pers.zhaoqi.solstice.inventory.service.IInventoryOperationService;
import pers.zhaoqi.solstice.product.entity.ProductInfo;
import pers.zhaoqi.solstice.product.service.IProductInfoService;

/**
 * <p>
 * 库存操作表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/inventory/inventoryOperation")
public class InventoryOperationController {

    public static final String MESSAGE_HEAD = "[库存操作]";

    Logger logger = LoggerFactory.getLogger(InventoryOperationController.class);
    @Autowired
    private IInventoryOperationService inventoryOperationService;


    @PostMapping
    public ActionResult newInventoryOperation(@RequestBody InventoryOperationInputDTO inventoryOperationInputDTO) {
        try {
            if (inventoryOperationService.newInventoryOperation(inventoryOperationInputDTO)) {
                return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SUCCESS_SAVA_MESSAGE);
            }else {
                throw new Exception("保存错误");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return Result.failed(ResultCodeAndMessage.FAIL_SAVA,MESSAGE_HEAD+ResultCodeAndMessage.FAIL_SAVA_MESSAGE);

        }
    }

}
