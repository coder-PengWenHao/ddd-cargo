package com.coderpwh.cargo.application.service.impl;

import com.coderpwh.cargo.application.assembler.command.CargoBookAssembler;
import com.coderpwh.cargo.application.command.CargoBookCommand;
import com.coderpwh.cargo.application.service.CargoService;
import com.coderpwh.cargo.domain.model.CargoBook;
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


    @Override
    public Boolean saveCarGo(CargoBookCommand command) {

        CargoBook domain = cargoBookAssembler.toEntity(command);


      /*  Box domain = boxAssembler.toEntity(boxCommand);
        BoxRecordService boxRecordService = new BoxRecordService(boxRepository);

        return boxRecordService.save(domain);*/

        return null;
    }
}
