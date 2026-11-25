package com.ecofood.core.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.ecofood.core.dto.*;
import com.ecofood.core.enums.*;
import com.ecofood.core.service.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;

class ProductClientsTest {
  @Test void commandClientDelegatesAllProductOperations() {
    ProductService service = mock(ProductService.class);
    CoreProductClient client = new CoreProductClient(service);
    ProductCreateRequest create = new ProductCreateRequest(ProductTypeEnum.STANDALONE, "Milk", null, List.of(), null, null, "Drinks", null);
    ProductUpdateRequest update = new ProductUpdateRequest("Milk", null, List.of(), null, null, 0L, "MILK", "Drinks", null);
    ProductDecisionRequest decision = new ProductDecisionRequest("Missing recipe");
    ProductResponse response = mock(ProductResponse.class);
    when(service.create(create)).thenReturn(response);
    when(service.update("p", update)).thenReturn(response);
    when(service.submit("p")).thenReturn(response);
    when(service.approve("p", 1, null)).thenReturn(response);
    when(service.reject("p", 1, decision)).thenReturn(response);
    when(service.newVersion("p")).thenReturn(response);
    assertThat(client.create(create)).isSameAs(response);
    assertThat(client.update("p", update)).isSameAs(response);
    assertThat(client.submit("p")).isSameAs(response);
    assertThat(client.approve("p", 1)).isSameAs(response);
    assertThat(client.reject("p", 1, decision)).isSameAs(response);
    assertThat(client.newVersion("p")).isSameAs(response);
  }

  @Test void queryClientDelegatesIncludingApprovedVersionForProposition() {
    ProductQueryService service = mock(ProductQueryService.class);
    CoreProductQueryClient client = new CoreProductQueryClient(service);
    Pageable pageable = PageRequest.of(0, 20);
    Page<ProductResponse> page = Page.empty(pageable);
    ProductResponse response = mock(ProductResponse.class);
    List<ProductVersionResponse> versions = List.of(new ProductVersionResponse(1, 0L, ProductStatusEnum.APPROVED, "Milk", null, null));
    when(service.list("milk", ProductTypeEnum.STANDALONE, ProductStatusEnum.APPROVED, pageable)).thenReturn(page);
    when(service.getById("p")).thenReturn(response);
    when(service.versions("p")).thenReturn(versions);
    when(service.getApprovedVersion("p", 1)).thenReturn(response);
    when(service.getVersion("p",1)).thenReturn(response);
    when(service.processes("p")).thenReturn(List.of());
    assertThat(client.list("milk", ProductTypeEnum.STANDALONE, ProductStatusEnum.APPROVED, pageable)).isSameAs(page);
    assertThat(client.getById("p")).isSameAs(response);
    assertThat(client.versions("p")).isSameAs(versions);
    assertThat(client.getApprovedVersion("p", 1)).isSameAs(response);
    assertThat(client.getVersion("p",1)).isSameAs(response);
    assertThat(client.processes("p")).isEmpty();
  }
}
