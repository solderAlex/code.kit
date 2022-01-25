package ${p.pageQuery.pkg};

import lombok.Data;

/**
 * ${p.entity.simpleName} AddParam
 *
 * @author Code.kit
 * @date ${date()}
 */
@Data
public class PageQuery {

    /**
    * 当前页码
    */
    private Integer page = 1;

    /**
    * 每页条数
    */
    private Integer limit = 20;

    public Integer getOffset() {
        return (page - 1) * limit;
    }
}