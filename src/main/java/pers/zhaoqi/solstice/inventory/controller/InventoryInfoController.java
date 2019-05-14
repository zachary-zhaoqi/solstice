package pers.zhaoqi.solstice.inventory.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zhaoqi.solstice.common.enums.ResultCodeAndMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.common.utils.Utils;
import pers.zhaoqi.solstice.inventory.dto.InventoryInfoInputDTO;
import pers.zhaoqi.solstice.inventory.dto.InventoryInfoOutputDTO;
import pers.zhaoqi.solstice.inventory.entity.InventoryInfo;
import pers.zhaoqi.solstice.inventory.service.IInventoryInfoService;
import pers.zhaoqi.solstice.product.entity.ProductInfo;
import pers.zhaoqi.solstice.product.service.IProductInfoService;

import java.time.LocalDateTime;
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

    Logger logger = LoggerFactory.getLogger(InventoryInfoController.class);
    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private IInventoryInfoService inventoryInfoService;

    /**
     * @param inventoryInfoInputDTO
     * @return
     * @author zhaoqi
     */
    @GetMapping
    public ActionResult queryInventoryInfo(InventoryInfoInputDTO inventoryInfoInputDTO) {
        try {
            ProductInfo productInfo = new ProductInfo();
            BeanUtils.copyProperties(inventoryInfoInputDTO, productInfo);
            InventoryInfo inventoryInfo = new InventoryInfo();
            BeanUtils.copyProperties(inventoryInfoInputDTO, inventoryInfo);
            QueryWrapper inventoryInfoQueryWrapper = new QueryWrapper(inventoryInfo);
            //判断用于查询product中是否有条件，若有根据其查出商品id列表，用作查库存的条件
            if (!Utils.checkObjFieldIsNull(productInfo)) {
                QueryWrapper productInfoQueryWrapper = new QueryWrapper(productInfo);
                productInfoQueryWrapper.select("id");
                List<Integer> idList = productInfoService.list(productInfoQueryWrapper);
                inventoryInfoQueryWrapper.in("product_id", idList);
            }
            List<LocalDateTime> creatTimeRange = inventoryInfoInputDTO.getCreatTimeRange();
            if (creatTimeRange != null) {
                inventoryInfoQueryWrapper.between("create_ime", creatTimeRange.get(0), creatTimeRange.get(1));
            }
            List<InventoryInfo> inventoryInfoList = inventoryInfoService.list(inventoryInfoQueryWrapper);

            //查询所有相关联的产品信息
            inventoryInfoQueryWrapper.select("product_id");
            List productIdList = inventoryInfoService.list(inventoryInfoQueryWrapper);
            List<ProductInfo> productInfoList=new ArrayList<>();
            if (productIdList.size() > 0) {
                QueryWrapper queryWrapper = new QueryWrapper();
                inventoryInfoQueryWrapper.in("id", productIdList);
                productInfoList = productInfoService.list(queryWrapper);
            }

            //装配至outputDTO中
            List<InventoryInfoOutputDTO> inventoryInfoOutputDTOList = new ArrayList<>();
            for (InventoryInfo inventoryInfoItem : inventoryInfoList) {
                InventoryInfoOutputDTO inventoryInfoOutputDTO = new InventoryInfoOutputDTO();
                for(int i = 0; i < productInfoList.size(); i++)
                {
                    ProductInfo productInfoItem=productInfoList.get(i);
                    if (productInfoItem.getId()==inventoryInfoItem.getProductId()){
                        BeanUtils.copyProperties(productInfoItem, inventoryInfoOutputDTO);
                        inventoryInfoOutputDTO.setProductId(productInfoItem.getId());
                        productInfoList.remove(i);
                    }
                }
                BeanUtils.copyProperties(inventoryInfoItem, inventoryInfoOutputDTO);
                inventoryInfoOutputDTO.setInventoryId(inventoryInfoItem.getId());
                inventoryInfoOutputDTOList.add(inventoryInfoOutputDTO);
            }
            return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SUCCESS_QUERY_MESSAGE, inventoryInfoOutputDTOList);

        } catch (Exception e) {
            logger.debug(MESSAGE_HEAD + ResultCodeAndMessage.FAIL_QUERY_MESSAGE + "\n" + e.getMessage());
            return Result.failed(ResultCodeAndMessage.FAIL_QUERY, MESSAGE_HEAD + ResultCodeAndMessage.FAIL_QUERY_MESSAGE);
        }
    }

    @PostMapping
    public ActionResult newInventoryInfo(@RequestBody InventoryInfoInputDTO inventoryInfoInputDTO){
        if (inventoryInfoInputDTO.getProductId() == null) {
            return Result.failed(ResultCodeAndMessage.FAIL_INPUT_DATA_DEFICIENCY,MESSAGE_HEAD + ResultCodeAndMessage.FAIL_INPUT_DATA_DEFICIENCY_MESSAGE+"必须存在产品ID：productId");
        }
        InventoryInfo inventoryInfo=new InventoryInfo();
        Utils.FillCreate(inventoryInfo);
        inventoryInfo.setBatchSn("inv"+Utils.GeneratesUniqueCode());
        inventoryInfo.setProductId(inventoryInfoInputDTO.getProductId());

        if (inventoryInfoInputDTO.getSpecification() == null) {
            inventoryInfo.setSpecification("普装");
        } else {
            inventoryInfo.setSpecification(inventoryInfoInputDTO.getSpecification());
        }

        if (inventoryInfoInputDTO.getNumber() == null) {
            inventoryInfo.setNumber(0);
        } else {
            inventoryInfo.setSpecification(inventoryInfoInputDTO.getSpecification());
        }

        if (inventoryInfoService.save(inventoryInfo)){
            return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SUCCESS_SAVA_MESSAGE,inventoryInfo);
        }else {
            return Result.failed(ResultCodeAndMessage.FAIL_SAVA,MESSAGE_HEAD+ResultCodeAndMessage.FAIL_SAVA_MESSAGE);
        }
    }

}
