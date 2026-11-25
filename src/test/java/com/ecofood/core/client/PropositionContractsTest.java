package com.ecofood.core.client;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.ecofood.core.dto.*;
import com.ecofood.core.enums.*;
import com.ecofood.core.service.*;
import jakarta.validation.Validation;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class PropositionContractsTest {
    @Test
    void quarterlyRevenueValidatesPeriodsAndKeepsLegacyMonthsReadable() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var validator = factory.getValidator();
            assertThat(
                            validator.validate(
                                    new EconomicMetricsRequest(
                                            null,
                                            2026,
                                            null,
                                            null,
                                            null,
                                            null,
                                            4,
                                            new BigDecimal("0.01"))))
                    .isEmpty();
            assertThat(
                            validator.validate(
                                    new EconomicMetricsRequest(11, 2026, null, null, null, null)))
                    .isEmpty();
            assertThat(
                            validator.validate(
                                    new EconomicMetricsRequest(
                                            null, 2026, null, null, null, null, 5, BigDecimal.ONE)))
                    .isNotEmpty();
            assertThat(
                            validator.validate(
                                    new EconomicMetricsRequest(
                                            11, 2026, null, null, null, null, 4, BigDecimal.ONE)))
                    .isNotEmpty();
            assertThat(
                            validator.validate(
                                    new EconomicMetricsRequest(
                                            null,
                                            2026,
                                            null,
                                            null,
                                            null,
                                            null,
                                            null,
                                            BigDecimal.ONE)))
                    .isNotEmpty();
            assertThat(
                            validator.validate(
                                    new EconomicMetricsRequest(
                                            null,
                                            2026,
                                            null,
                                            null,
                                            null,
                                            null,
                                            4,
                                            new BigDecimal("-1"))))
                    .isNotEmpty();
        }
    }

    @Test
    void marketBeanValidationRejectsNegativeAndMissingAmounts() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var validator = factory.getValidator();
            assertThat(
                            validator.validate(
                                    new MarketConfigurationRequest(
                                            "USD",
                                            BigDecimal.ONE,
                                            new BigDecimal("8"),
                                            BigDecimal.ZERO)))
                    .isEmpty();
            assertThat(validator.validate(new MarketConfigurationRequest("USD", null, null, null)))
                    .isNotEmpty();
            assertThat(
                            validator.validate(
                                    new MarketConfigurationRequest(
                                            "USD", new BigDecimal("-1"), null, null)))
                    .isNotEmpty();
            assertThat(
                            validator.validate(
                                    new MarketConfigurationRequest(
                                            "USD", BigDecimal.ONE, new BigDecimal("101"), null)))
                    .isNotEmpty();
            assertThat(PlanStatusEnum.values())
                    .containsExactly(
                            PlanStatusEnum.DRAFT,
                            PlanStatusEnum.PENDING_REVIEW,
                            PlanStatusEnum.APPROVED,
                            PlanStatusEnum.REJECTED);
        }
    }

    @Test
    void coreClientsDelegateWithoutPersistenceOrBusinessLogic() {
        var service = mock(PropositionService.class);
        var query = mock(PropositionQueryService.class);
        var commands = new CorePropositionClient(service);
        var reads = new CorePropositionQueryClient(query);
        var revision = new RevisionRequest(2L);
        commands.submitPlan("p", "plan", revision);
        commands.approvePlan("p", "plan", revision);
        reads.getById("p");
        verify(service).submitPlan("p", "plan", revision);
        verify(service).approvePlan("p", "plan", revision);
        verify(query).getById("p");
    }
}
