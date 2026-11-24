package com.ecofood.core.service;

import com.ecofood.core.dto.AuditLogDtos.*;
import java.util.List;

public interface AuditLogService {
  void record(Event event);
  Page list(Filter filter);
  Entry detail(String id);
  List<String> actors(String prefix);
}
