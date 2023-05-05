package com.coderpwh.cargo.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.cargo.application.command.CargoBookPageQuery;
import com.coderpwh.cargo.domain.model.CarGoRepository;
import com.coderpwh.cargo.domain.model.CargoBook;
import com.coderpwh.cargo.infrastructure.persistence.converter.CargoBookConverter;
import com.coderpwh.cargo.infrastructure.persistence.entity.CargoBookDO;
import com.coderpwh.cargo.infrastructure.persistence.mapper.CargoBookDOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author coderpwh
 * @date 2023/4/27 17:38
 */
@Service
public class CarGoRepositoryImpl extends ServiceImpl<CargoBookDOMapper, CargoBookDO> implements CarGoRepository {

    @Resource
    private CargoBookConverter cargoBookConverter;

    @Override
    public boolean saveBatch(List<CargoBook> list) {
        return false;
    }

    @Override
    public boolean save(CargoBook cargoBook) {
        CargoBookDO cargoBookDO = cargoBookConverter.toDTO(cargoBook);
        int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, 5 - 1));
        String id = "CARGO-NO-" + rs;
        cargoBookDO.setId(id);
        return super.save(cargoBookDO);
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
    public CargoBook getById(Integer id) {
        CargoBookDO cargoBookDO = super.getById(id);
        CargoBook cargoBook = cargoBookConverter.toEntity(cargoBookDO);
        return cargoBook;
    }


    @Override
    public boolean del(Integer id) {
        return false;
    }


    /***
     *  通过senderPhone查询
     * @param senderPhone
     * @return
     */
    @Override
    public CargoBook getBySenderPhone(String senderPhone) {
        LambdaQueryWrapper<CargoBookDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CargoBookDO::getSenderPhone, senderPhone);
        CargoBookDO cargoBookDO = this.getOne(queryWrapper);

        CargoBook cargoBook = cargoBookConverter.toEntity(cargoBookDO);
        return cargoBook;
    }


    /***
     * 分页查询
     * @param query
     * @return
     */
    @Override
    public List<CargoBook> queryByPage(CargoBookPageQuery query) {
        return null;
    }

}
