package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.PageDto;
import java.util.Map;

public interface PaginationDtoService<T> {
  PageDto<T> getPageDto(Integer currentPage, Integer itemsOnPage);
  PageDto<T> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters);
}
