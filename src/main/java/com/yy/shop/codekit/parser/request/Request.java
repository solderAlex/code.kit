package com.yy.shop.codekit.parser.request;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2020/6/1
 * @since 1.0
 */
public class Request {
    /**
     * 系统用户名
     */
    private String user = System.getProperty("user.name");

    private EntityRequest entity = new EntityRequest();
    private MapperRequest mapper = new MapperRequest();
    private ExtMapperRequest extMapper = new ExtMapperRequest();
    private MapperXmlRequest mapperXml = new MapperXmlRequest();
    private ExtMapperXmlRequest extMapperXml = new ExtMapperXmlRequest();
//    private BaseParamRequest baseParam = new BaseParamRequest();
//    private AddParamRequest addParam = new AddParamRequest();
//    private UpdateParamRequest updateParam = new UpdateParamRequest();
    private PageQueryRequest pageQuery = new PageQueryRequest();
//    private QueryRequest query = new QueryRequest();
//    private ViewRequest view = new ViewRequest();
//    private ConverterRequest converter = new ConverterRequest();
//
//    private ResultRequest result = new ResultRequest();
//    private PageResultRequest pageResult = new PageResultRequest();
//    private ServiceRequest service = new ServiceRequest();
//    private ControllerRequest controller = new ControllerRequest();

    public String getUser() {
        return user;
    }

    public EntityRequest getEntity() {
        return entity;
    }

    public MapperRequest getMapper() {
        return mapper;
    }

    public ExtMapperRequest getExtMapper() {
        return extMapper;
    }

    public MapperXmlRequest getMapperXml() {
        return mapperXml;
    }

    public ExtMapperXmlRequest getExtMapperXml() {
        return extMapperXml;
    }

    public PageQueryRequest getPageQuery() {
        return pageQuery;
    }
}
