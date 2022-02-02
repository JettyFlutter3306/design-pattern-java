package cn.element.templatemethod.jdbc;

import java.sql.ResultSet;

/**
 * ORM映射定制化接口
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
