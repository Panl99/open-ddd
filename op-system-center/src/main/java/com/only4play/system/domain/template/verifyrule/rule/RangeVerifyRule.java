package com.only4play.system.domain.template.verifyrule.rule;

import cn.hutool.core.util.NumberUtil;
import com.only4play.system.infrastructure.constants.TemplateErrorCode;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.validator.GenericValidator;

public class RangeVerifyRule extends AbstractVerifyRule {

    @Setter
    @Getter
    private BigDecimal min;

    @Setter
    @Getter
    private BigDecimal max;

    public RangeVerifyRule() {
        super(VerifyTypeEnum.RANGE);
    }

    @Override
    public Optional<String> verify(String input) {
        boolean db = GenericValidator.isDouble(input);
        if (db) {
            if (NumberUtil.isLess(new BigDecimal(input), min)) {
                return Optional.of(TemplateErrorCode.INPUT_TOO_SMALL.getName());
            }
            if (NumberUtil.isGreater(new BigDecimal(input), max)) {
                return Optional.of(TemplateErrorCode.INPUT_TOO_BIG.getName());
            }
        } else {
            return Optional.of(TemplateErrorCode.FORMAT_ERROR.getName());
        }
        return Optional.empty();

    }
}
