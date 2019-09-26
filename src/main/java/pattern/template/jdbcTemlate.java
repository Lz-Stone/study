package pattern.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public  class jdbcTemlate {
    private DataSource dataSource;
    public jdbcTemlate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    private Connection getConnection () throws Exception{
        return  this.dataSource.getConnection();
    }

    private PreparedStatement createPsmt(Connection conn, String sql) throws Exception{
        return conn.prepareStatement(sql);
    }

    private ResultSet excuteQuery(PreparedStatement psmt,Object[] values) throws  Exception{
        for (int i = 0; i<values.length; i++){
            psmt.setObject(i,values[i]);
        }
        return psmt.executeQuery();
    }
    private void closeStatement(Statement statement) throws Exception{
        statement.close();
    }

    private void closeResult(ResultSet resultSet) throws Exception{
        resultSet.close();
    }

    private void closeCoon(Connection connection) throws Exception{ }


    private List<?> parseResultSet(ResultSet rs, RowMapper rowMapper) throws Exception{
        List<Object> result = new ArrayList<Object>();
        int rownum =1;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs,rownum++));
        }
        return result;
    }

    public List<?> executeQuery (String sql,RowMapper<?> rowMapper, Object[] values){
        try{
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = this.createPsmt(connection,sql);
            ResultSet rs= this.excuteQuery(preparedStatement,values);
            List<?> result =this.parseResultSet(rs,rowMapper);
            this.closeResult(rs);
            this.closeStatement(preparedStatement);
            this.closeCoon(connection);
            return result;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public abstract Object processResult(ResultSet rs,int rownum) throws Exception;
}
