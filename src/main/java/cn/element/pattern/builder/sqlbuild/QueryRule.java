package cn.element.pattern.builder.sqlbuild;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * QueryRule主要功能用于构造查询条件
 */
public final class QueryRule implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int ASC_ORDER = 101;
    public static final int DESC_ORDER = 102;
    public static final int LIKE = 1;
    public static final int IN = 2;
    public static final int NOT_IN = 3;
    public static final int BETWEEN = 4;
    public static final int EQ = 5;
    public static final int NOT_EQ = 6;
    public static final int GT = 7;
    public static final int GE = 8;
    public static final int LT = 9;
    public static final int LE = 10;
    public static final int IS_NULL = 11;
    public static final int IS_NOT_NULL = 12;
    public static final int IS_EMPTY = 13;
    public static final int IS_NOT_EMPTY = 14;
    public static final int AND = 201;
    public static final int OR = 202;
    private final List<Rule> ruleList = new ArrayList<>();
    private final List<QueryRule> queryRuleList = new ArrayList<>();
    private String propertyName;

    private QueryRule() {

    }

    private QueryRule(String propertyName) {
        this.propertyName = propertyName;
    }

    public static QueryRule getInstance() {
        return new QueryRule();
    }

    /**
     * 添加升序规则
     */
    public QueryRule addAscOrder(String propertyName) {
        ruleList.add(new Rule(ASC_ORDER, propertyName));
        return this;
    }

    /**
     * 添加降序规则
     */
    public QueryRule addDescOrder(String propertyName) {
        ruleList.add(new Rule(DESC_ORDER, propertyName));
        return this;
    }

    public QueryRule andIsNull(String propertyName) {
        ruleList.add(new Rule(IS_NULL, propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andIsNotNull(String propertyName) {
        ruleList.add(new Rule(IS_NOT_NULL, propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andIsEmpty(String propertyName) {
        ruleList.add(new Rule(IS_EMPTY, propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andIsNotEmpty(String propertyName) {
        ruleList.add(new Rule(IS_NOT_EMPTY, propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andLike(String propertyName, Object value) {
        ruleList.add(new Rule(LIKE, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andEqual(String propertyName, Object value) {
        ruleList.add(new Rule(EQ, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andBetween(String propertyName, Object... values) {
        ruleList.add(new Rule(BETWEEN, propertyName, values).setAndOr(AND));
        return this;
    }

    public QueryRule andIn(String propertyName, Object... values) {
        ruleList.add(new Rule(IN, propertyName, values).setAndOr(AND));
        return this;
    }

    public QueryRule andIn(String propertyName, List<Object> values) {
        ruleList.add(new Rule(IN, propertyName, new Object[] { values }).setAndOr(AND));
        return this;
    }

    public QueryRule andNotIn(String propertyName, List<Object> values) {
        ruleList.add(new Rule(NOT_IN, propertyName, new Object[] { values }).setAndOr(AND));
        return this;
    }

    public QueryRule orNotIn(String propertyName, Object... values) {
        this.ruleList.add(new Rule(NOT_IN, propertyName, values).setAndOr(OR));
        return this;
    }


    public QueryRule andNotEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(NOT_EQ, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andGreaterThan(String propertyName, Object value) {
        this.ruleList.add(new Rule(GT, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andGreaterEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(GE, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andLessThan(String propertyName, Object value) {
        this.ruleList.add(new Rule(LT, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andLessEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(LE, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }


    public QueryRule orIsNull(String propertyName) {
        this.ruleList.add(new Rule(IS_NULL, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsNotNull(String propertyName) {
        this.ruleList.add(new Rule(IS_NOT_NULL, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsEmpty(String propertyName) {
        this.ruleList.add(new Rule(IS_EMPTY, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsNotEmpty(String propertyName) {
        this.ruleList.add(new Rule(IS_NOT_EMPTY, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orLike(String propertyName, Object value) {
        this.ruleList.add(new Rule(LIKE, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(EQ, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orBetween(String propertyName, Object... values) {
        this.ruleList.add(new Rule(BETWEEN, propertyName, values).setAndOr(OR));
        return this;
    }

    public QueryRule orIn(String propertyName, List<Object> values) {
        this.ruleList.add(new Rule(IN, propertyName, new Object[] { values }).setAndOr(OR));
        return this;
    }

    public QueryRule orIn(String propertyName, Object... values) {
        this.ruleList.add(new Rule(IN, propertyName, values).setAndOr(OR));
        return this;
    }

    public QueryRule orNotEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(NOT_EQ, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orGreaterThan(String propertyName, Object value) {
        this.ruleList.add(new Rule(GT, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orGreaterEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(GE, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orLessThan(String propertyName, Object value) {
        this.ruleList.add(new Rule(LT, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orLessEqual(String propertyName, Object value) {
        this.ruleList.add(new Rule(LE, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public List<Rule> getRuleList() {
        return ruleList;
    }

    public List<QueryRule> getQueryRuleList() {
        return queryRuleList;
    }

    public String getPropertyName() {
        return propertyName;
    }

    @Data
    protected static class Rule implements Serializable {
        private static final long serialVersionUID = 1L;
        private int type;  //规则的类型
        private String propName;
        private Object[] values;
        private int andOr = AND;

        public Rule(int paramInt, String paramString) {
            this.propName = paramString;
            this.type = paramInt;
        }

        public Rule(int paramInt, String paramString, Object[] paramsArrayOfObject) {
            this.propName = paramString;
            this.values = paramsArrayOfObject;
            this.type = paramInt;
        }

        public Rule setAndOr(int andOr) {
            this.andOr = andOr;
            return this;
        }

        public int getAndOr() {
            return this.andOr;
        }

        public Object[] getValues() {
            return this.values;
        }

        public int getType() {
            return this.type;
        }

        public String getPropName() {
            return propName;
        }
    }
}
