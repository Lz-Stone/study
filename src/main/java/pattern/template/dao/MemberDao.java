package pattern.template.dao;
import pattern.template.RowMapper;
import pattern.template.entity.Member;
import pattern.template.jdbcTemlate;
import java.sql.ResultSet;
import java.util.List;


public class MemberDao {

    private pattern.template.jdbcTemlate jdbcTemlate= new jdbcTemlate(null);

    public List<?> query(){
        String sql ="select * from t_member";
        return jdbcTemlate.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rownum) throws Exception{
                Member member =new Member();
                member.setUserName(rs.getString("uerName"));
                member.setPassword(rs.getString("password"));
                return member;
            }
        }, null);
    }

}
