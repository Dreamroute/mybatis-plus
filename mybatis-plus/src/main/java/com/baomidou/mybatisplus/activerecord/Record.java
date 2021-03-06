/**
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.activerecord;

import org.apache.ibatis.session.SqlSession;

import com.baomidou.mybatisplus.toolkit.TableInfo;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;

/**
 * <p>
 * ActiveRecord 模式 CRUD
 * </p>
 * 
 * @author hubin
 * @param <T>
 * @Date 2016-11-06
 */
public class Record {

	/**
	 * 获取Session 默认自动提交
	 * <p>
	 * 特别说明:这里获取SqlSession时这里虽然设置了自动提交但是如果事务托管了的话 是不起作用的 切记!!
	 * <p/>
	 *
	 * @return SqlSession
	 */
	public static SqlSession sqlSession(Class<?> clazz) {
		return sqlSession(clazz, true);
	}

	/**
	 * <p>
	 * 获取Session
	 * </p>
	 * 
	 * @param autoCommit
	 *            true自动提交false则相反
	 * @return SqlSession
	 */
	public static SqlSession sqlSession(Class<?> clazz, boolean autoCommit) {
		return table(clazz).getSqlSessionFactory().openSession(autoCommit);
	}

	/**
	 * 获取TableInfo
	 * 
	 * @return TableInfo
	 */
	public static TableInfo table(Class<?> clazz) {
		return TableInfoHelper.getTableInfo(clazz);
	}

}
