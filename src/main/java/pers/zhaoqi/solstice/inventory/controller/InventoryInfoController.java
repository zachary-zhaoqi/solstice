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

import java.util.ArrayList;
import java.util.List;

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

    public static final String MESSAGE_HEAD = "[库存记录]";

    Logger logger = LoggerFactory.getLogger(ProductInfo.class);
    @Autowired
    private IProductInfoService productInfoService;

    private IInventoryInfoService inventoryInfoService;

    /**
     * @param inventoryInfoInputDTO
     * @return
     * @author zhaoqi
     */
    @GetMapping
    public ActionResult queryInventoryInfo(@RequestBody InventoryInfoInputDTO inventoryInfoInputDTO) {
        try {
            //todo:先判断用于查询product的四个属性是否为空，若不为空再查，为空则直接查inventoryInfo
            ProductInfo productInfo = new ProductInfo();
            BeanUtils.copyProperties(inventoryInfoInputDTO, productInfo);
            QueryWrapper productInfoQueryWrapper = new QueryWrapper(productInfo);
            List<ProductInfo> productInfoList = productInfoService.list(productInfoQueryWrapper);
            List<InventoryInfoOutputDTO> inventoryInfoOutputDTOList = new ArrayList<>();
            if (productInfoList != null && productInfoList.size() != 0) {//todo:查询到的productList只取其id 组装为list，然后用wrapper的in方法来使用即可
                for (ProductInfo productInfoItem : productInfoList) {
                    InventoryInfo inventoryInfo = new InventoryInfo();
                    BeanUtils.copyProperties(productInfoItem, inventoryInfo);
                    QueryWrapper inventoryInfoQueryWrapper = new QueryWrapper(inventoryInfo);
                    if (inventoryInfoInputDTO.getCreatTimeRange() != null && inventoryInfoInputDTO.getCreatTimeRange().size() != 0) {
                        productInfoQueryWrapper.between("createTime", inventoryInfoInputDTO.getCreatTimeRange().get(0), inventoryInfoInputDTO.getCreatTimeRange().get(1));
                    }
                    List<InventoryInfo> inventoryInfoList = inventoryInfoService.list(inventoryInfoQueryWrapper);
                    InventoryInfoOutputDTO inventoryInfoOutputDTO = new InventoryInfoOutputDTO();
                    for (InventoryInfo inventoryInfoItem : inventoryInfoList) {
                        BeanUtils.copyProperties(productInfoItem, inventoryInfoOutputDTO);
                        BeanUtils.copyProperties(inventoryInfoItem, inventoryInfoOutputDTO);
                        inventoryInfoOutputDTO.setProductId(productInfoItem.getId());
                        inventoryInfoOutputDTO.setInventoryId(inventoryInfoItem.getId());
                        inventoryInfoOutputDTOList.add(inventoryInfoOutputDTO);
                    }
                }
                return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SUCCESS_QUERY_MESSAGE, inventoryInfoOutputDTOList);
            } else {
                return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SELECT_NULL, productInfoList);//todo:成功返回上面的那个，出错了返回下面那个，这个就不需要了。
            }
        } catch (Exception e) {
            logger.debug(MESSAGE_HEAD + ResultCodeAndMessage.FAIL_QUERY_MESSAGE+"\n"+ e.getMessage());
            return Result.failed(ResultCodeAndMessage.FAIL_QUERY, MESSAGE_HEAD + ResultCodeAndMessage.FAIL_QUERY_MESSAGE);
        }
    }
}
