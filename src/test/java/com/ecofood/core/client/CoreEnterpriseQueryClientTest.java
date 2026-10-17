package com.ecofood.core.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ecofood.core.dto.EnterpriseResponse;
import com.ecofood.core.service.EnterpriseQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoreEnterpriseQueryClientTest {

  @Mock private EnterpriseQueryService enterpriseQueryService;

  @Test
  void getByIdDelegatesToEnterpriseQueryService() {
    CoreEnterpriseQueryClient client = new CoreEnterpriseQueryClient(enterpriseQueryService);
    EnterpriseResponse expected = EnterpriseResponse.builder().enterpriseCompanyName("Acme").build();
    when(enterpriseQueryService.getById("e1")).thenReturn(expected);

    assertThat(client.getById("e1")).isSameAs(expected);
  }
}
