package pers.zhaoqi.solstice.brand.service.impl;

import pers.zhaoqi.solstice.brand.entity.BrandInfo;
import pers.zhaoqi.solstice.brand.mapper.BrandInfoMapper;
import pers.zhaoqi.solstice.brand.service.IBrandInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌信息表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class BrandInfoServiceImpl extends ServiceImpl<BrandInfoMapper, BrandInfo> implements IBrandInfoService {

}
