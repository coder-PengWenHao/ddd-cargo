package com.coderpwh.cargo.application.assembler.command;

import com.coderpwh.cargo.application.command.CargoBookCommand;
import com.coderpwh.cargo.domain.model.CargoBook;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/4/27 16:18
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoBookAssembler extends MapStructConverter<CargoBookCommand, CargoBook> {

}
