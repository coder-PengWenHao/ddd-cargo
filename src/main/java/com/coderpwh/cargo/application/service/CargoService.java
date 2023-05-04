package com.coderpwh.cargo.application.service;

import com.coderpwh.cargo.application.command.CarGoBookQuery;
import com.coderpwh.cargo.application.command.CargoBookCommand;

/**
 * CarGo
 *
 * @author coderpwh
 * @date 2023/4/27 15:59
 */
public interface CargoService {


    /***
     * 新增
     * @param command
     * @return
     */
    Boolean saveCarGo(CargoBookCommand command);


    /***
     * 查询
     * @param query
     * @return
     */
    String queryCargoBook(CarGoBookQuery query);
}
