package ${p.entity.pkg};

import lombok.Data;

import java.io.Serializable;
<%for(item in p.entity.importStatements){%>
${item}
<%}%>

/**
 * 描述：${p.entity.simpleName} Entity
 *
 * @author Code.kit
 * @date ${date()}
 */
@Data
public class ${p.entity.name} implements Serializable {

<%for(item in p.entity.fields){%>
<%if(item.comment != null && item.comment != ''){%>

    /**
     * ${item.comment}
     */
<%}%>
    private ${item.javaSimpleType} ${item.field};
<%}%>
}