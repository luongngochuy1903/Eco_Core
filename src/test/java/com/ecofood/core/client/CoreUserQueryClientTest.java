package com.ecofood.core.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ecofood.core.dto.UserQueryResponse;
import com.ecofood.core.service.UserQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoreUserQueryClientTest {

  @Mock private UserQueryService userQueryService;

  @Test
  void getByIdDelegatesToUserQueryService() {
    CoreUserQueryClient client = new CoreUserQueryClient(userQueryService);
    UserQueryResponse expected = UserQueryResponse.builder().username("jane.doe").build();
    when(userQueryService.getById("u1")).thenReturn(expected);

    assertThat(client.getById("u1")).isSameAs(expected);
  }

  @Test
  void getByEmailDelegatesToUserQueryService() {
    CoreUserQueryClient client = new CoreUserQueryClient(userQueryService);
    UserQueryResponse expected = UserQueryResponse.builder().email("jane.doe@example.com").build();
    when(userQueryService.getByEmail("jane.doe@example.com")).thenReturn(expected);

    assertThat(client.getByEmail("jane.doe@example.com")).isSameAs(expected);
  }
}
