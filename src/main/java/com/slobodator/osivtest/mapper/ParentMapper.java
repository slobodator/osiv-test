package com.slobodator.osivtest.mapper;

import com.slobodator.osivtest.dto.ParentDto;
import com.slobodator.osivtest.entity.Parent;
import org.mapstruct.Mapper;

@Mapper(
    uses = ChildMapper.class
)
public interface ParentMapper {
  ParentDto toDto(Parent parent);
}
