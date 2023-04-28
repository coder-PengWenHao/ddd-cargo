package com.coderpwh.cargo.application.service.impl;

import com.coderpwh.cargo.application.assembler.command.CargoBookAssembler;
import com.coderpwh.cargo.application.command.CargoBookCommand;
import com.coderpwh.cargo.application.service.CargoService;
import com.coderpwh.cargo.domain.model.CarGoRepository;
import com.coderpwh.cargo.domain.model.CargoBook;
import com.coderpwh.cargo.domain.service.DomainCarGoService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public Boolean saveCarGo(CargoBookCommand command) {
        CargoBook domain = cargoBookAssembler.toEntity(command);
        // 领域层
        DomainCarGoService domainCarGoService = new DomainCarGoService(carGoRepository);

        return domainCarGoService.save(domain);
    }
}
