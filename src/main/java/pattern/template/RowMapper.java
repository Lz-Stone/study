package pattern.template;

import java.sql.ResultSet;

public interface RowMapper<T> {
    public T mapRow(ResultSet rs, int rownum) throws Exception;

}
