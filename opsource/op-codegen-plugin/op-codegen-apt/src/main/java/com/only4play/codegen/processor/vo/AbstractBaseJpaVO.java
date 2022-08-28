package com.only4play.codegen.processor.vo;

import com.only4play.jpa.support.BaseJpaAggregate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AbstractBaseJpaVO {
    @Schema(
            title = "数据版本"
    )
    private int version;
    @Schema(
        title = "主键"
    )
    private Long id;
    @Schema(
            title = "创建时间"
    )
    private Long createdAt;
    @Schema(
            title = "修改时间"
    )
    private Long updatedAt;

    protected AbstractBaseJpaVO(BaseJpaAggregate source) {
        this.setVersion(source.getVersion());
        this.setId(source.getId());
        this.setCreatedAt(source.getCreatedAt().toEpochMilli());
        this.setUpdatedAt(source.getUpdatedAt().toEpochMilli());
    }

    protected AbstractBaseJpaVO() {
    }
}
