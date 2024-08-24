package cn.com.pism.mybatis.core.constant;

/**
 * 定义mybatis 相关常量
 *
 * @author perccyking
 * @since 24-08-23 16:33
 */
public class MybatisConstants {

    private MybatisConstants() {
    }

    public static final String SQL_SCRIPT = "<script>\n %s \n</script>";

    public static final String BATCH_INSERT = "batchInsert";

    public static final String INSERT_OR_UPDATE_BY_ID = "insertOrUpdateById";

    public static final String INSERT_OR_UPDATE_SELECTIVE = "insertOrUpdateSelective";

    public static final String BATCH_UPDATE = "batchUpdate";

    public static final String BATCH_UPDATE_SELECTIVE = "batchUpdateSelective";

    public static final String INSERT_SELECTIVE = "insertSelective";

    public static final String UPDATE_SELECTIVE_BY_PRIMARY_KEY = "updateSelectiveByPrimaryKey";
}
