package com.ecofood.core.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ecofood.core.dto.TenantResponse;
import com.ecofood.core.service.TenantQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoreTenantQueryClientTest {

  @Mock private TenantQueryService tenantQueryService;

  @Test
  void getByIdDelegatesToTenantQueryService() {
    CoreTenantQueryClient client = new CoreTenantQueryClient(tenantQueryService);
    TenantResponse expected = TenantResponse.builder().tenantName("Acme").build();
    when(tenantQueryService.getById("t1")).thenReturn(expected);

    assertThat(client.getById("t1")).isSameAs(expected);
  }

  @Test
  void getByRealmDelegatesToTenantQueryService() {
    CoreTenantQueryClient client = new CoreTenantQueryClient(tenantQueryService);
    TenantResponse expected = TenantResponse.builder().tenantName("Acme").realm("acme-realm").build();
    when(tenantQueryService.getByRealm("acme-realm")).thenReturn(expected);

    assertThat(client.getByRealm("acme-realm")).isSameAs(expected);
  }
}
