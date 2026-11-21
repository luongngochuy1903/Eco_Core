package com.ecofood.core.service;

import com.ecofood.core.dto.ComplaintDtos;
import com.ecofood.core.dto.ComplaintView;
import com.ecofood.core.enums.ComplaintStatusEnum;
import com.ecofood.core.enums.ComplaintTypeEnum;
import java.util.List;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface ComplaintService {
  ComplaintView create(ComplaintDtos.Create input);
  ComplaintDtos.Page<? extends ComplaintView> customerList(ComplaintStatusEnum status, int page, int size);
  ComplaintView customerDetail(String id);
  ComplaintView reply(String id, ComplaintDtos.Reply input);
  ComplaintDtos.Capabilities capabilities();
  List<ComplaintDtos.Assignee> assignees(ComplaintTypeEnum type);
  ComplaintDtos.Page<? extends ComplaintView> adminList(ComplaintTypeEnum type, ComplaintStatusEnum status, int page, int size);
  ComplaintDtos.Detail adminDetail(String id);
  ComplaintView action(String id, String action, ComplaintDtos.Action input);
}
