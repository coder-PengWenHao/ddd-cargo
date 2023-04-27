package com.coderpwh.cargo.infrastructrue.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.cargo.domain.model.CarGoRepository;
import com.coderpwh.cargo.domain.model.CargoBook;
import com.coderpwh.cargo.infrastructrue.persistence.entity.CargoBookDO;
import com.coderpwh.cargo.infrastructrue.persistence.mapper.CargoBookDOMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author coderpwh
 * @date 2023/4/27 17:38
 */
@Service
public class CarGoRepositoryImpl extends ServiceImpl<CargoBookDOMapper, CargoBookDO> implements CarGoRepository {


    @Override
    public boolean saveBatch(List<CargoBook> list) {
        return false;
    }

    @Override
    public boolean save(CargoBook cargoBook) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public boolean updateById(CargoBook cargoBook) {
        return false;
    }

    @Override
    public CargoBookDO getById(Integer id) {
        return null;
    }

    @Override
    public List<CargoBookDO> getByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public boolean del(Integer id) {
        return false;
    }

    @Override
    public CargoBookDO getByName(String name) {
        return null;
    }
}
