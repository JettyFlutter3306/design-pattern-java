package cn.element.pattern.builder.sqlbuild;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 根据QueryRule自动构建SQL语句
 */
public class QueryRuleSqlBuilder {

    private int CURR_INDEX = 0;         //记录参数所在位置
    private final List<String> properties;    //保存列名列表
    private final List<Object> values;        //保存参数值列表
    private final List<Order> orders;         //保存排序规则列表

    private String whereSql = "";
    private String orderSql = "";
    private Object[] valueArr = new Object[]{};
    private final Map<Object, Object> valueMap = new HashMap<>();


    /**
     * 获取查询条件
     */
    public String getWhereSql() {
        return whereSql;
    }

    /**
     * 获得排序条件
     */
    public String getOrderSql() {
        return orderSql;
    }

    /**
     * 获得参数值列表
     */
    public Object[] getValues() {
        return valueArr;
    }

    /**
     * 获取参数列表
     */
    public Map<Object, Object> getValueMap() {
        return valueMap;
    }

    /**
     * 创建SQL构造器
     */
    public QueryRuleSqlBuilder(QueryRule queryRule) {
        CURR_INDEX = 0;
        properties = new ArrayList<>();
        values = new ArrayList<>();
        orders = new ArrayList<>();

        for (QueryRule.Rule rule : queryRule.getRuleList()) {
            switch (rule.getType()) {
                case QueryRule.BETWEEN:
                    processBetween(rule);
                    break;
                case QueryRule.EQ:
                    processEqual(rule);
                    break;
                case QueryRule.LIKE:
                    processLike(rule);
                    break;
                case QueryRule.NOT_EQ:
                    processNotEqual(rule);
                    break;
                case QueryRule.GT:
                    processGreaterThen(rule);
                    break;
                case QueryRule.GE:
                    processGreaterEqual(rule);
                    break;
                case QueryRule.LT:
                    processLessThen(rule);
                    break;
                case QueryRule.LE:
                    processLessEqual(rule);
                    break;
                case QueryRule.IN:
                    processIN(rule);
                    break;
                case QueryRule.NOT_IN:
                    processNotIN(rule);
                    break;
                case QueryRule.IS_NULL:
                    processIsNull(rule);
                    break;
                case QueryRule.IS_NOT_NULL:
                    processIsNotNull(rule);
                    break;
                case QueryRule.IS_EMPTY:
                    processIsEmpty(rule);
                    break;
                case QueryRule.IS_NOT_EMPTY:
                    processIsNotEmpty(rule);
                    break;
                case QueryRule.ASC_ORDER:
                case QueryRule.DESC_ORDER:
                    processOrder(rule);
                    break;
                default:
                    throw new IllegalArgumentException("type " + rule.getType() + " not supported.");
            }
        }

        appendWhereSql();   //拼装where语句
        appendOrderSql();   //拼装排序语句
        appendValues();     //拼装参数值
    }

    /**
     * 去掉order
     */
    private String removeOrders(String sql) {
        Pattern p = Pattern.compile("order\\s*by[\\w|\\W\\s\\S]*", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sql);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {
            m.appendReplacement(sb, "");
        }

        m.appendTail(sb);

        return sb.toString();
    }

    /**
     * 去掉select
     */
    private String removeSelect(String sql) {
        if (sql.toLowerCase().matches("from\\s+")) {
            int beginPos = sql.toLowerCase().indexOf("from");
            return sql.substring(beginPos);
        } else {
            return sql;
        }
    }

    /**
     * 处理like
     */
    private  void processLike(QueryRule.Rule rule) {
        if (ArrayUtil.isEmpty(rule.getValues())) {
            return;
        }
        Object obj = rule.getValues()[0];

        if (obj != null) {
            String value = obj.toString();

            if (!StringUtils.isEmpty(value)) {
                value = value.replace('*', '%');
                obj = value;
            }
        }

        add(rule.getAndOr(), rule.getPropName(), "like", "%"+rule.getValues()[0]+"%");
    }

    /**
     * 处理between
     */
    private  void processBetween(QueryRule.Rule rule) {
        if ((ArrayUtil.isEmpty(rule.getValues())) || (rule.getValues().length < 2)) {
            return;
        }
        add(rule.getAndOr(),rule.getPropName(),"","between",rule.getValues()[0],"and");
        add(0,"","","",rule.getValues()[1],"");
    }

    /**
     * 处理 =
     */
    private  void processEqual(QueryRule.Rule rule) {
        if (ArrayUtil.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(),rule.getPropName(),"=",rule.getValues()[0]);
    }

    /**
     * 处理 <>
     */
    private  void processNotEqual(QueryRule.Rule rule) {
        if (ArrayUtil.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(),rule.getPropName(),"<>",rule.getValues()[0]);
    }

    /**
     * 处理 >
     */
    private  void processGreaterThen(
            QueryRule.Rule rule) {
        if (ArrayUtil.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(),rule.getPropName(),">",rule.getValues()[0]);
    }

    /**
     * 处理>=
     */
    private  void processGreaterEqual(
            QueryRule.Rule rule) {
        if (ArrayUtil.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(),rule.getPropName(),">=",rule.getValues()[0]);
    }

    /**
     * 处理<
     */
    private  void processLessThen(QueryRule.Rule rule) {
        if (ArrayUtil.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(),rule.getPropName(),"<",rule.getValues()[0]);
    }

    /**
     * 处理<=
     */
    private  void processLessEqual(
            QueryRule.Rule rule) {
        if (ArrayUtil.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(),rule.getPropName(),"<=",rule.getValues()[0]);
    }

    /**
     * 处理  is null
     */
    private  void processIsNull(QueryRule.Rule rule) {
        add(rule.getAndOr(),rule.getPropName(),"is null",null);
    }

    /**
     * 处理 is not null
     */
    private  void processIsNotNull(QueryRule.Rule rule) {
        add(rule.getAndOr(),rule.getPropName(),"is not null",null);
    }

    /**
     * 处理  <>''
     */
    private  void processIsNotEmpty(QueryRule.Rule rule) {
        add(rule.getAndOr(),rule.getPropName(),"<>","''");
    }

    /**
     * 处理 =''
     */
    private  void processIsEmpty(QueryRule.Rule rule) {
        add(rule.getAndOr(),rule.getPropName(),"=","''");
    }


    /**
     * 处理in和not in
     */
    private void inAndNotIn(QueryRule.Rule rule,String name){
        if (ArrayUtil.isEmpty(rule.getValues())) {
            return;
        }

        if ((rule.getValues().length == 1) && (rule.getValues()[0] != null)
                && (rule.getValues()[0] instanceof List)) {
            List<Object> list = (List<Object>) rule.getValues()[0];

            if ((list != null) && (list.size() > 0)) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == 0 && i == list.size() - 1) {
                        add(rule.getAndOr(),rule.getPropName(),"",name + " (",list.get(i),")");
                    } else if (i == 0) {
                        add(rule.getAndOr(),rule.getPropName(),"",name + " (",list.get(i),"");
                    }

                    if (i > 0 && i < list.size() - 1) {
                        add(0,"",",","",list.get(i),"");
                    }

                    if (i == list.size() - 1 && i != 0) {
                        add(0,"",",","",list.get(i),")");
                    }
                }
            }
        } else {
            Object[] list =  rule.getValues();
            for (int i = 0; i < list.length; i++) {
                if (i == 0 && i == list.length - 1) {
                    add(rule.getAndOr(),rule.getPropName(),"",name + " (",list[i],")");
                } else if (i == 0) {
                    add(rule.getAndOr(),rule.getPropName(),"",name + " (",list[i],"");
                }

                if (i > 0 && i < list.length - 1) {
                    add(0,"",",","",list[i],"");
                }

                if (i == list.length - 1 && i != 0) {
                    add(0, "", ",", "", list[i], ")");
                }
            }
        }
    }

    /**
     * 处理 not in
     */
    private void processNotIN(QueryRule.Rule rule){
        inAndNotIn(rule, "not in");
    }

    /**
     * 处理 in
     */
    private  void processIN(QueryRule.Rule rule) {
        inAndNotIn(rule, "in");
    }

    /**
     * 处理 order by
     * @param rule 查询规则
     */
    private void processOrder(QueryRule.Rule rule) {
        switch (rule.getType()) {
            case QueryRule.ASC_ORDER:
                if (!StringUtils.isEmpty(rule.getPropName())) {  // propertyName非空
                    orders.add(Order.asc(rule.getPropName()));
                }
                break;
            case QueryRule.DESC_ORDER:
                if (!StringUtils.isEmpty(rule.getPropName())) {  // propertyName非空
                    orders.add(Order.desc(rule.getPropName()));
                }
                break;
            default:
                break;
        }
    }


    /**
     * 加入到sql查询规则队列
     * @param andOr and 或者 or
     * @param key 列名
     * @param split 列名与值之间的间隔
     * @param value 值
     */
    private  void add(int andOr,String key,String split ,Object value){
        add(andOr, key, split, "", value, "");
    }

    /**
     * 加入到sql查询规则队列
     * @param andOr and 或则 or
     * @param key 列名
     * @param split 列名与值之间的间隔
     * @param prefix 值前缀
     * @param value 值
     * @param suffix 值后缀
     */
    private  void add(int andOr,String key,String split ,String prefix,Object value,String  suffix){
        String andOrStr = (0 == andOr ? "" :(QueryRule.AND == andOr ? " and " : " or "));
        properties.add(CURR_INDEX, andOrStr + key + " " + split + prefix + (null != value ? " ? " : " ") + suffix);
        if(null != value){
            values.add(CURR_INDEX,value);
            CURR_INDEX ++;
        }
    }


    /**
     * 拼装 where 语句
     */
    private void appendWhereSql(){
        StringBuilder whereSql = new StringBuilder();

        for (String p : properties) {
            whereSql.append(p);
        }

        this.whereSql = removeSelect(removeOrders(whereSql.toString()));
    }

    /**
     * 拼装排序语句
     */
    private void appendOrderSql(){
        StringBuilder orderSql = new StringBuilder();

        for (int i = 0 ; i < orders.size(); i ++) {
            if (i > 0) {
                orderSql.append(",");
            }
            orderSql.append(orders.get(i).toString());
        }

        this.orderSql = removeSelect(removeOrders(orderSql.toString()));
    }

    /**
     * 拼装参数值
     */
    private void appendValues(){
        Object [] val = new Object[values.size()];
        for (int i = 0; i < values.size(); i ++) {
            val[i] = values.get(i);
            valueMap.put(i, values.get(i));
        }
        this.valueArr = val;
    }

    public String build(String tableName){
        String ws = removeFirstAnd(this.getWhereSql());
        String whereSql = ("".equals(ws) ? ws : (" where " + ws));
        String sql = "select * from " + tableName + whereSql;
        Object [] values = this.getValues();
        String orderSql = this.getOrderSql();
        orderSql = (StringUtils.isEmpty(orderSql) ? " " : (" order by " + orderSql));
        sql += orderSql;
        return sql;
    }


    private String removeFirstAnd(String sql){
        if(StringUtils.isEmpty(sql)){return sql;}
        return sql.trim().toLowerCase().replaceAll("^\\s*and", "") + " ";
    }


}
