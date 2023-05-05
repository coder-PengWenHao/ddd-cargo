package com.coderpwh.cargo.application.service.impl;

import com.coderpwh.cargo.application.assembler.command.CargoBookAssembler;
import com.coderpwh.cargo.application.assembler.domain.CargoBookDTOAssembler;
import com.coderpwh.cargo.application.assembler.vo.CargoBookVOAssembler;
import com.coderpwh.cargo.application.command.CargoBookCommand;
import com.coderpwh.cargo.application.command.CargoBookPageQuery;
import com.coderpwh.cargo.application.service.CargoService;
import com.coderpwh.cargo.application.vo.CarGoBookVO;
import com.coderpwh.cargo.common.database.PageUtils;
import com.coderpwh.cargo.domain.model.CarGoRepository;
import com.coderpwh.cargo.domain.model.CargoBook;
import com.coderpwh.cargo.domain.service.DomainCarGoService;
import com.coderpwh.cargo.domain.specification.CarGoSpecification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author coderpwh
 * @date 2023/4/27 16:00
 */
@Service
public class CargoServiceImpl implements CargoService {

    @Resource
    private CargoBookAssembler cargoBookAssembler;

    @Resource
    private CarGoRepository carGoRepository;

    @Resource
    private CargoBookDTOAssembler cargoBookDTOAssembler;

    @Resource
    private CargoBookVOAssembler cargoBookVOAssembler;


    /**
     * 新增
     *
     * @param command
     * @return
     */
    @Override
    public Boolean saveCarGo(CargoBookCommand command) {
        CargoBook domain = cargoBookAssembler.toEntity(command);

        // 校验
        CarGoSpecification carGoSpecification = new CarGoSpecification(carGoRepository);
        carGoSpecification.isGarGo(command.getSenderPhone());

        // 领域层
        DomainCarGoService domainCarGoService = new DomainCarGoService(carGoRepository);

        return domainCarGoService.save(domain);
    }


    /**
     * 查询详情
     *
     * @param senderPhone
     * @return
     */
    @Override
    public CarGoBookVO queryCargoBook(String senderPhone) {
        // 校验
        CarGoSpecification carGoSpecification = new CarGoSpecification(carGoRepository);
        carGoSpecification.isSenderPhone(senderPhone);

        // 领域层
        DomainCarGoService domainCarGoService = new DomainCarGoService(carGoRepository, cargoBookDTOAssembler, cargoBookVOAssembler);

        // 查询
        CarGoBookVO carGoBookVO = domainCarGoService.queryCargoBook(senderPhone);

        return carGoBookVO;
    }


    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PageUtils queryCargoBookPage(CargoBookPageQuery query) {

        // 领域层
        DomainCarGoService domainCarGoService = new DomainCarGoService(carGoRepository, cargoBookDTOAssembler, cargoBookVOAssembler);

        // 分页查询
        PageUtils pageUtils = domainCarGoService.queryCargoBookPage(query);

        return pageUtils;
    }


}
