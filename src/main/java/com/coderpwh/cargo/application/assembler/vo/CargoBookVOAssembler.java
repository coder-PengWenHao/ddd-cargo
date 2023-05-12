package com.coderpwh.cargo.application.assembler.vo;

import com.coderpwh.cargo.application.dto.CargoBookDTO;
import com.coderpwh.cargo.application.vo.CarGoBookVO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/5/4 14:03
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoBookVOAssembler extends MapStructConverter<CarGoBookVO, CargoBookDTO> {


}
