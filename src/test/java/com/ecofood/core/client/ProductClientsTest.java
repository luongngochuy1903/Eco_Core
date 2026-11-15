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
    ProductCreateRequest create = new ProductCreateRequest(ProductTypeEnum.STANDALONE, "Milk", null, null, List.of(), null, null, "MILK", "Drinks", null, List.of());
    ProductUpdateRequest update = new ProductUpdateRequest("Milk", null, List.of(), null, null, 0L, "MILK", "Drinks", null, List.of());
    ProductDecisionRequest decision = new ProductDecisionRequest("Missing recipe");
    ProductResponse response = mock(ProductResponse.class);
    when(service.create(create)).thenReturn(response);
    when(service.update("p", update)).thenReturn(response);
    when(service.submit("p")).thenReturn(response);
    when(service.approve("p")).thenReturn(response);
    when(service.reject("p", decision)).thenReturn(response);
    when(service.newVersion("p")).thenReturn(response);
    assertThat(client.create(create)).isSameAs(response);
    assertThat(client.update("p", update)).isSameAs(response);
    assertThat(client.submit("p")).isSameAs(response);
    assertThat(client.approve("p")).isSameAs(response);
    assertThat(client.reject("p", decision)).isSameAs(response);
    assertThat(client.newVersion("p")).isSameAs(response);
  }

  @Test void queryClientDelegatesIncludingApprovedVersionForProposition() {
    ProductQueryService service = mock(ProductQueryService.class);
    CoreProductQueryClient client = new CoreProductQueryClient(service);
    Pageable pageable = PageRequest.of(0, 20);
    Page<ProductResponse> page = Page.empty(pageable);
    ProductResponse response = mock(ProductResponse.class);
    List<ProductVersionResponse> versions = List.of(new ProductVersionResponse(1, 0L, ProductStatusEnum.APPROVED, "Milk", null, null));
    when(service.list("milk", ProductTypeEnum.MASTER, ProductStatusEnum.APPROVED, pageable)).thenReturn(page);
    when(service.getById("p")).thenReturn(response);
    when(service.versions("p")).thenReturn(versions);
    when(service.getApprovedVersion("p", 1)).thenReturn(response);
    when(service.getVersion("p",1)).thenReturn(response);
    when(service.processes("p")).thenReturn(List.of());
    assertThat(client.list("milk", ProductTypeEnum.MASTER, ProductStatusEnum.APPROVED, pageable)).isSameAs(page);
    assertThat(client.getById("p")).isSameAs(response);
    assertThat(client.versions("p")).isSameAs(versions);
    assertThat(client.getApprovedVersion("p", 1)).isSameAs(response);
    assertThat(client.getVersion("p",1)).isSameAs(response);
    assertThat(client.processes("p")).isEmpty();
  }
}
