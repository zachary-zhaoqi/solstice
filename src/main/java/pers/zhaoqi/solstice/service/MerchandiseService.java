package pers.zhaoqi.solstice.service;

import org.springframework.stereotype.Service;
import pers.zhaoqi.solstice.entity.Merchandise;

import java.util.List;

public interface MerchandiseService {
    Merchandise selectById(int id);

    List<Merchandise> selectList();
}
