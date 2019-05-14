package pers.zhaoqi.solstice.inventory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.zhaoqi.solstice.dictionary.entity.DataDictionary;
import pers.zhaoqi.solstice.dictionary.service.IDataDictionaryService;
import pers.zhaoqi.solstice.inventory.dto.InventoryOperationInputDTO;
import pers.zhaoqi.solstice.inventory.entity.InventoryInfo;
import pers.zhaoqi.solstice.inventory.entity.InventoryOperation;
import pers.zhaoqi.solstice.inventory.mapper.InventoryOperationMapper;
import pers.zhaoqi.solstice.inventory.service.IInventoryInfoService;
import pers.zhaoqi.solstice.inventory.service.IInventoryOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存操作表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Transactional
@Service
public class InventoryOperationServiceImpl extends ServiceImpl<InventoryOperationMapper, InventoryOperation> implements IInventoryOperationService {

    @Autowired
    private IInventoryInfoService inventoryInfoService;
    @Autowired
    private IDataDictionaryService dataDictionaryService;

    @Override
    public boolean newInventoryOperation(InventoryOperationInputDTO inventoryOperationInputDTO) throws Exception {
        //根据inputDTO中的batchSn查询库存
        QueryWrapper queryWrapper1=new QueryWrapper(new InventoryInfo().setBatchSn(inventoryOperationInputDTO.getBatchSn()));
        InventoryInfo inventoryInfo=inventoryInfoService.getOne(queryWrapper1);

        //判断进行出库还是入库
        QueryWrapper queryWrapper=new QueryWrapper(new DataDictionary().setKey("mapping").setValue(inventoryOperationInputDTO.getOperationType())).select("label_zh_cn");
        DataDictionary dataDictionary=dataDictionaryService.getOne(queryWrapper);
        if ("出库".equals(dataDictionary.getLabelZhCn())){
            //查询出的库存减去操作的数量，inputDTO中的number
        }else if("入库".equals(dataDictionary.getLabelZhCn())){
            //查询出的库存加上操作的数量，inputDTO中的number
        }else{
            throw new Exception("请填写正确的操作类型");
        }
        //判断库存数量是否大于零，
        if (inventoryInfo.getNumber() < 0) {
            //最好可以封装一个库存错误类
            throw new Exception("库存不足无法执行。");
        }
        //更新inventoryInfo

        //保存inventoryOperation

        //返回保存操作所返回的布尔值
        return true;
    }
}
