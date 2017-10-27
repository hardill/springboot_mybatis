package com.karle.tk.base.TkMapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper 不能被扫描 单独放 全路径配置到 properties中 mapper.mappers
 * 
 * @author hardill
 *
 * @param <T>
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {
}