package com.coderpwh.cargo.web;

import com.coderpwh.cargo.application.command.CarGoBookQuery;
import com.coderpwh.cargo.application.command.CargoBookCommand;
import com.coderpwh.cargo.application.service.CargoService;
import com.coderpwh.cargo.common.util.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author coderpwh
 * @date 2023/4/23 16:09
 */
@RestController
@RequestMapping("/cargo")
public class CargoController {


    @Resource
    private CargoService cargoService;


    /***
     * 新增
     * @param command
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveCarGo(@RequestBody @Valid CargoBookCommand command) {
        Boolean flag = cargoService.saveCarGo(command);
        return Result.update(flag);
    }


    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Result queryCargoBook(@RequestBody @Valid CarGoBookQuery query) {
        return Result.ok(cargoService.queryCargoBook(query));
    }


}
