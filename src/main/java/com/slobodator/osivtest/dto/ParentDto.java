package com.slobodator.osivtest.dto;

import java.util.List;
import lombok.Data;

@Data
public class ParentDto {
  private Long id;
  private String name;
  private List<ChildDto> children;
}
