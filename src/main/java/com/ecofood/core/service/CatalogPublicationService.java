package com.ecofood.core.service;

import com.ecofood.core.dto.CatalogDtos;
import com.ecofood.core.enums.CatalogTypeEnum;
import java.util.List;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface CatalogPublicationService {
  CatalogDtos.Capabilities capabilities();
  CatalogDtos.Options options(CatalogTypeEnum type);
  CatalogDtos.Page<CatalogDtos.PlanOption> plans(CatalogTypeEnum type, String search, int page, int size);
  CatalogDtos.Page<CatalogDtos.View> list(CatalogTypeEnum type, String apiKey, int page, int size);
  CatalogDtos.View detail(String id);
  List<CatalogDtos.Audit> audit(String id);
  CatalogDtos.View save(String id, CatalogDtos.Draft input);
  CatalogDtos.View validate(String id, CatalogDtos.Revision input);
  CatalogDtos.View publish(String id, CatalogDtos.Revision input);
  CatalogDtos.View retire(String id, CatalogDtos.Revision input);
  CatalogDtos.Credential grant(String id, CatalogDtos.Grant input);
  List<CatalogDtos.PartnerScope> partnerOptions(String id);
  CatalogDtos.View revoke(String id, String partnerId, CatalogDtos.Revision input);
}
