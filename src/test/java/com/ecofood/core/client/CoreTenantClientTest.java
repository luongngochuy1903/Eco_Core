package com.ecofood.core.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ecofood.core.dto.TenantOnboardRequest;
import com.ecofood.core.dto.TenantOnboardResponse;
import com.ecofood.core.dto.TenantResponse;
import com.ecofood.core.service.TenantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoreTenantClientTest {

  @Mock private TenantService tenantService;

  @Test
  void onboardTenantDelegatesToTenantService() {
    CoreTenantClient client = new CoreTenantClient(tenantService);
    TenantOnboardRequest request = new TenantOnboardRequest();
    TenantOnboardResponse expected = TenantOnboardResponse.builder().tenantId("t1").build();
    when(tenantService.onboardTenant(request)).thenReturn(expected);

    assertThat(client.onboardTenant(request)).isSameAs(expected);
  }

  @Test
  void getByIdDelegatesToTenantService() {
    CoreTenantClient client = new CoreTenantClient(tenantService);
    TenantResponse expected = TenantResponse.builder().tenantName("Acme").build();
    when(tenantService.getById("t1")).thenReturn(expected);

    assertThat(client.getById("t1")).isSameAs(expected);
  }
}
