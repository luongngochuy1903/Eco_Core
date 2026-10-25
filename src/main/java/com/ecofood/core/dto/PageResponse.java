package com.ecofood.core.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Generic paginated-listing envelope — this project's first (everything else
 * exposes plain Lists). page/size echo back what was actually applied (after
 * any clamping), not necessarily what the caller requested.
 */
@Data
@AllArgsConstructor
@Builder
public class PageResponse<T> {
  private List<T> content;
  private int page;
  private int size;
  private long totalElements;
  private int totalPages;
}
