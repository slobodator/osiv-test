package com.slobodator.osivtest.mapper;

import com.slobodator.osivtest.dto.ChildDto;
import com.slobodator.osivtest.entity.Child;
import org.mapstruct.Mapper;

@Mapper
public interface ChildMapper {
  ChildDto toDto(Child child);
}
