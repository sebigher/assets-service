package com.affinion.gce.validator;

import com.affinion.gce.exception.DataValidationException;
import com.affinion.gce.model.asset.type.AdultSsn;
import com.affinion.gce.model.rule.RuleResult;
import com.affinion.gce.repository.AssetRepository;
import com.affinion.gce.service.RuleService;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

public class AdultSsnValidator extends AssetDataValidator<AdultSsn> {
    public AdultSsnValidator(AssetRepository repository,
                             RuleService service,
                             String brmsToken,
                             AdultSsn asset) {
        super(repository, service, brmsToken, asset);
    }

    @Override
    protected Mono<AdultSsn> validateData(RuleResult result) {
        return super.validateData(result)
                .filter(a -> !StringUtils.isEmpty(a.getSsn()))
                .switchIfEmpty(Mono.error(new DataValidationException("SSN can not be empty")))
                .flatMap(a -> validatePattern(a.getSsn(), "adultssn", result))
                .flatMap(a -> validateDuplicate(a.type().id()));
    }
}
