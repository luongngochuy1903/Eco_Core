package com.ecofood.core.service;

import com.ecofood.core.dto.CatalogDtos;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface CatalogExternalService {
  CatalogDtos.ExternalPrincipal authenticate(String header);
  CatalogDtos.Session session(CatalogDtos.ExternalPrincipal principal);
  CatalogDtos.Catalog read(CatalogDtos.ExternalPrincipal principal, String id, int version, String planId, String search, int page, int size);
}
