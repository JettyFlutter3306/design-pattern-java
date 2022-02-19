package cn.element.pattern.builder.sqlbuild;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addAscOrder("age")
                    .andEqual("address", "南京")
                    .andLike("name", "tom");

        QueryRuleSqlBuilder builder = new QueryRuleSqlBuilder(queryRule);

        System.out.println(builder.build("`tb_member`"));
        System.out.println("Params: " + Arrays.toString(builder.getValues()));
    }
}
