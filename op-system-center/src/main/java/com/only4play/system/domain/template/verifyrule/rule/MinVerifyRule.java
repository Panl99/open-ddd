package com.only4play.system.domain.template.verifyrule.rule;

import cn.hutool.core.util.NumberUtil;
import com.only4play.system.infrastructure.constants.TemplateErrorCode;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.validator.GenericValidator;

public class MinVerifyRule extends AbstractVerifyRule {

    @Getter
    @Setter
    private BigDecimal minValue;

    public MinVerifyRule() {
        super(VerifyTypeEnum.MIN_VALUE);
    }

    @Override
    public Optional<String> verify(String input) {
        boolean db = GenericValidator.isDouble(input);
        if (db) {
            if (NumberUtil.isLess(new BigDecimal(input), minValue)) {
                return Optional.of(TemplateErrorCode.INPUT_TOO_SMALL.getName());
            }
        } else {
            return Optional.of(TemplateErrorCode.FORMAT_ERROR.getName());
        }
        return Optional.empty();
    }
}
