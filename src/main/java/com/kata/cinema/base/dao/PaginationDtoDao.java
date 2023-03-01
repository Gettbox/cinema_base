package com.kata.cinema.base.dao;

import java.util.List;
import java.util.Map;

public interface PaginationDtoDao<T> {
  List<T> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters);
  Long getResultTotal(Map<String, Object> parameters);
}
