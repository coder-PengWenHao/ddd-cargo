package com.coderpwh.cargo.domain.service;

import com.coderpwh.cargo.application.assembler.domain.CargoBookDTOAssembler;
import com.coderpwh.cargo.application.assembler.vo.CargoBookVOAssembler;
import com.coderpwh.cargo.application.command.CargoBookPageQuery;
import com.coderpwh.cargo.application.dto.CargoBookDTO;
import com.coderpwh.cargo.application.vo.CarGoBookVO;
import com.coderpwh.cargo.common.database.PageUtils;
import com.coderpwh.cargo.domain.model.CarGoRepository;
import com.coderpwh.cargo.domain.model.CargoBook;

import javax.annotation.Resource;
import java.util.List;

/**
 * 领域层
 *
 * @author coderpwh
 * @date 2023/4/27 16:27
 */
public class DomainCarGoService {
    private CarGoRepository carGoRepository;

    private CargoBookDTOAssembler cargoBookDTOAssembler;

    private CargoBookVOAssembler cargoBookVOAssembler;


    /***
     * 新增时调用
     * @param repository
     * @param cargoBookDTOAssembler
     * @param cargoBookVOAssembler
     */
    public DomainCarGoService(CarGoRepository repository, CargoBookDTOAssembler cargoBookDTOAssembler, CargoBookVOAssembler cargoBookVOAssembler) {
        this.carGoRepository = repository;
        this.cargoBookDTOAssembler = cargoBookDTOAssembler;
        this.cargoBookVOAssembler = cargoBookVOAssembler;
    }


    /***
     * 新增时领域函数
     * @param repository
     */
    public DomainCarGoService(CarGoRepository repository) {
        this.carGoRepository = repository;
    }

    /***
     *  保存
     * @param domain
     * @return
     */
    public Boolean save(CargoBook domain) {
        return carGoRepository.save(domain);
    }


    /***
     * 查询
     * @param senderPhone
     * @return
     */
    public CarGoBookVO queryCargoBook(String senderPhone) {

        CargoBook cargoBook = carGoRepository.getBySenderPhone(senderPhone);

        CargoBookDTO cargoBookDTO = cargoBookDTOAssembler.toDTO(cargoBook);

        CarGoBookVO carGoBookVO = cargoBookVOAssembler.toDTO(cargoBookDTO);

        return carGoBookVO;
    }


    /***
     * 分页查询
     * @param query
     * @return
     */
    public PageUtils queryCargoBookPage(CargoBookPageQuery query) {

        PageUtils<CarGoBookVO> pageUtils = new PageUtils<>();
        pageUtils.setPageNum(query.getPageNum());
        pageUtils.setPageSize(query.getPageSize());

        List<CargoBook> list = carGoRepository.queryByPage(query);

        // 转换
        List<CargoBookDTO> cargoBookDTOList = cargoBookDTOAssembler.toDTO(list);
        List<CarGoBookVO> carGoBookVOList = cargoBookVOAssembler.toDTO(cargoBookDTOList);

        pageUtils.setList(carGoBookVOList);
        return pageUtils;
    }
}
