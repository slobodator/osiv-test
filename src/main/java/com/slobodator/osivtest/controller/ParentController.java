package com.slobodator.osivtest.controller;

import com.slobodator.osivtest.dto.ParentDto;
import com.slobodator.osivtest.service.ParentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {
  private final ParentService parentService;

  @GetMapping
  @SneakyThrows
  List<ParentDto> getParents() {
    var all = parentService.getParents();
    Thread.sleep(10_000L);
    return all;
  }

  @GetMapping("/{id}")
  ParentDto getParent(@PathVariable Long id) {
    return parentService.getParent(id);
  }
}
