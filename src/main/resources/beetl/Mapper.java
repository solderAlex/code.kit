package ${p.mapper.pkg};

import ${p.entity.pkg}.${p.entity.name};

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：${p.entity.simpleName} mapper
 *
 * @author Code.kit
 * @date ${date()}
 */
@Repository
public interface ${p.mapper.name} {

    /**
     * 查询
     *
     * @param id 主键id
     * @return ${p.entity.name}
     */
    ${p.entity.name} getById(${p.entity.idType} id);

    /**
     * id列表查询
     *
     * @param ids 主键id集合
     * @return ${p.entity.name}集合
     */
    List<${p.entity.name}> listByIds(List<${p.entity.idType}> ids);

    /**
     * 插入
     *
     * @param record ${p.entity.name}对象
     * @return 影响行数
     */
    int insert(${p.entity.name} record);

    /**
     * 批量插入
     *
     * @param records ${p.entity.name}集合
     * @return 影响行数
     */
    int insertBatch(List<${p.entity.name}> records);

    /**
     * 更新
     *
     * @param record ${p.entity.name}对象
     * @return 影响行数
     */
    int updateById(${p.entity.name} record);

    /**
     * 删除
     *
     * @param id 主键id
     * @return 影响行数
     */
    int deleteById(${p.entity.idType} id);
}