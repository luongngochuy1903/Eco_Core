package com.ecofood.core.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ecofood.core.dto.CustomerIdentityScope;
import com.ecofood.core.dto.CustomerInvoiceReference;
import com.ecofood.core.service.CustomerInvoiceService;
import org.junit.jupiter.api.Test;

class CoreCustomerInvoiceClientTest {
  private final CustomerInvoiceService service = mock(CustomerInvoiceService.class);
  private final CoreCustomerInvoiceClient client = new CoreCustomerInvoiceClient(service);
  private final CustomerIdentityScope scope = mock(CustomerIdentityScope.class);

  @Test
  void forwardsTheVerifiedScopeWithoutSubstitutingCustomerOrTenant() {
    var reference = mock(CustomerInvoiceReference.class);
    when(service.requireOwned(scope, "invoice")).thenReturn(reference);
    assertSame(reference, client.requireOwned(scope, "invoice"));
    verify(service).requireOwned(scope, "invoice");
    verifyNoMoreInteractions(service);
  }

  @Test
  void propagatesOwnershipFailureWithoutReturningAnInvoice() {
    var failure = new IllegalStateException("Invoice unavailable");
    when(service.requireOwned(scope, "invoice")).thenThrow(failure);
    var actual = assertThrows(IllegalStateException.class, () -> client.requireOwned(scope, "invoice"));
    assertSame(failure, actual);
  }
}
