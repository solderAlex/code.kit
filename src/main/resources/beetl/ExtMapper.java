package ${p.extMapper.pkg};

import ${p.mapper.pkg}.${p.mapper.name};
import ${p.entity.pkg}.${p.entity.name};
import com.yy.shophub.common.model.PageQuery;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：${p.entity.name} mapper
 *
 * @author Code.kit
 * @date ${date()}
 */
@Repository
public interface ${p.extMapper.name} extends ${p.mapper.name} {

    /**
     * 分页总数查询
     *
     * @param query 查询条件
     * @return 总数
     */
    <T extends PageQuery> int count(T query);

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 结果集
     */
    <T extends PageQuery> List<${p.entity.name}> listPage(T query);
}