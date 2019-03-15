package pers.zhaoqi.solstice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zhaoqi.solstice.entity.Merchandise;
import pers.zhaoqi.solstice.mapper.MerchandiseMapper;
import pers.zhaoqi.solstice.service.MerchandiseService;

import java.util.List;

@Service
public class MerchandiseServiceImpl implements MerchandiseService {

    @Autowired
    private MerchandiseMapper merchandiseMapper;

    @Override
    public Merchandise selectById(int id) {
        return merchandiseMapper.selectById(id);
    }

    @Override
    public List<Merchandise> selectList() {
        List<Merchandise> merchandises = merchandiseMapper.selectList(null);
        return merchandises;
    }


}
