package com.coderpwh.cargo.domain.service;

import com.coderpwh.cargo.domain.model.CarGoRepository;
import com.coderpwh.cargo.domain.model.CargoBook;

/**
 * @author coderpwh
 * @date 2023/4/27 16:27
 */
public class DomainCarGoService {


    private CarGoRepository carGoRepository;


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
}
