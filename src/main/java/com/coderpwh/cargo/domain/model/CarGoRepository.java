package com.coderpwh.cargo.domain.model;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.cargo.infrastructrue.persistence.entity.CargoBookDO;

import java.util.List;

/**
 * @author coderpwh
 * @date 2023/4/27 16:32
 */
public interface CarGoRepository extends IService<CargoBookDO> {


    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<CargoBook> list);

    /**
     * 添加一条数据
     *
     * @param box 领域对象
     * @return 是否执行成功
     */

    boolean save(CargoBook cargoBook);

    /**
     * 根据id删除
     *
     * @param id id
     * @return 是否执行成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据id修改
     *
     * @param cargoBookDO 实体对象
     * @return 是否执行成功
     */

    boolean updateById(CargoBook cargoBook);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    CargoBookDO getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<CargoBookDO> getByIds(List<Integer> ids);

    /**
     * 删除包厢
     *
     * @param id
     * @return
     */
    boolean del(Integer id);

    /**
     * 根据名称查询对象
     *
     * @param name 包厢名称
     * @return 查询后的对象
     */
    CargoBookDO getByName(String name);

}
