package com.ecofood.core.service;

import com.ecofood.core.dto.NotificationDtos;
import com.ecofood.core.dto.NotificationRuleView;
import com.ecofood.core.dto.NotificationView;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface NotificationManagementService {
  Map<String, Object> capabilities();
  Map<String, Object> options();
  List<? extends NotificationRuleView> rules();
  NotificationRuleView rule(String id);
  NotificationRuleView save(String id, NotificationDtos.RuleRequest input);
  NotificationRuleView enable(String id, NotificationDtos.EnabledRequest input);
  NotificationDtos.Page<? extends NotificationView> history(String event, String status, Instant from, Instant to, int page, int size);
  NotificationView detail(String id);
  NotificationView retry(String id, NotificationDtos.RetryRequest input);
}
