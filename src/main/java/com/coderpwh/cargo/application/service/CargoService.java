package com.coderpwh.cargo.application.service;

import com.coderpwh.cargo.application.command.CarGoBookQuery;
import com.coderpwh.cargo.application.command.CargoBookCommand;
import com.coderpwh.cargo.application.vo.CarGoBookVO;

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
     * 查询详情
     * @param query
     * @return
     */
    CarGoBookVO queryCargoBook(String senderPhone);
}
