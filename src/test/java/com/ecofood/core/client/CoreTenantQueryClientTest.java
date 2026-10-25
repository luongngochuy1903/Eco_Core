package com.ecofood.core.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ecofood.core.dto.TenantResponse;
import com.ecofood.core.service.TenantQueryService;
import java.util.List;
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
  void getAllByRealmDelegatesToTenantQueryService() {
    CoreTenantQueryClient client = new CoreTenantQueryClient(tenantQueryService);
    List<TenantResponse> expected = List.of(TenantResponse.builder().tenantName("Acme").realm("acme-realm").build());
    when(tenantQueryService.getAllByRealm("acme-realm")).thenReturn(expected);

    assertThat(client.getAllByRealm("acme-realm")).isSameAs(expected);
  }

  @Test
  void getScopedTenantIdsDelegatesToTenantQueryService() {
    CoreTenantQueryClient client = new CoreTenantQueryClient(tenantQueryService);
    List<String> expected = List.of("t1", "t2");
    when(tenantQueryService.getScopedTenantIds("t1")).thenReturn(expected);

    assertThat(client.getScopedTenantIds("t1")).isSameAs(expected);
  }
}
