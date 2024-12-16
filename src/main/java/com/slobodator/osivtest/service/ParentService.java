package com.slobodator.osivtest.service;

import com.slobodator.osivtest.dto.ParentDto;
import com.slobodator.osivtest.mapper.ParentMapper;
import com.slobodator.osivtest.repository.ParentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentService {
  private final ParentRepository parentRepository;
  private final ParentMapper parentMapper;

  public List<ParentDto> getParents() {
    return parentRepository
        .findAll()
        .stream()
        .map(parentMapper::toDto)
        .toList();
  }

  public ParentDto getParent(Long id) {
    return parentRepository
        .findById(id)
        .map(parentMapper::toDto)
        .orElseThrow();
  }
}
