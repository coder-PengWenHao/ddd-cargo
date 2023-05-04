package com.coderpwh.cargo.application.assembler.domain;

import com.coderpwh.cargo.application.dto.CargoBookDTO;
import com.coderpwh.cargo.common.util.mapstruct.MapStructConverter;
import com.coderpwh.cargo.domain.model.CargoBook;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/5/4 14:00
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoBookDTOAssembler extends MapStructConverter<CargoBookDTO, CargoBook> {

}
