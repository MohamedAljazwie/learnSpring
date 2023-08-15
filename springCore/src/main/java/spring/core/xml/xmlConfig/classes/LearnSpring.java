package spring.core.xml.xmlConfig.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class LearnSpring {

    private  ApplicationContext applicationContext;
    private  JdbcTemplate jdbcTemplate;
    private List list;
    private List names = new ArrayList();
    private static LearnSpring learnSpring;

    public void listProducts() {
        String sql = "SELECT * FROM onecard.product;";
        System.out.print(sql);
        List name = jdbcTemplate.query(sql, new RowMapper() {

            @Override
            public Object mapRow(ResultSet result, int paramInt)
                    throws SQLException {
            	Product product = new Product();
                product.setDescriptionAr(result.getString("descriptionAr"));
                product.setDescriptionEn(result.getString("descriptionEn"));
                product.setId(result.getLong("id"));
                product.setIndividualPrice(result.getDouble("individualPrice"));
                product.setMinStockAmount(result.getLong("minStockAmount"));
                product.setNameAr(result.getString("nameAr"));
                product.setNameEn(result.getString("nameEn"));

                return product;
            }

        });
        list = name;
        names.add("id");

        names.add("individualPrice");
        names.add("nameEn");
        names.add("nameAr");
        names.add("descriptionAr");
        names.add("descriptionEn");

    }

    private  LearnSpring(ApplicationContext context) {
        this.applicationContext = context;
        //applicationContext = new ClassPathXmlApplicationContext("A1pplicationContext.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbTemplet");

    }

    public static LearnSpring getInstance(ApplicationContext context) {
        if (learnSpring == null) {
            learnSpring = new LearnSpring(context);
        }
        return learnSpring;
    }

    public List getNames() {
        return names;
    }

    public List getList() {
        return list;
    }

}
