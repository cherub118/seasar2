/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.extension.jdbc.gen.internal.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.seasar.framework.exception.SQLRuntimeException;

/**
 * {@link Statement}に関するユーティリティクラスです。
 * 
 * @author taedium
 */
public class StatementUtil {

    /**
     * 
     */
    protected StatementUtil() {
    }

    /**
     * 実行します。
     * 
     * @param statement
     *            ステートメント
     * @param sql
     *            SQL
     * @return 最初の実行結果が結果セットをもつならば{@code true}
     * @throws SQLRuntimeException
     *             SQL例外が発生した場合
     */
    public static boolean execute(Statement statement, String sql)
            throws SQLRuntimeException {
        try {
            return statement.execute(sql);
        } catch (SQLException ex) {
            throw new SQLRuntimeException(ex);
        }
    }

    /**
     * 実行します。
     * 
     * @param statement
     *            ステートメント
     * @param sql
     *            SQL
     * @return 結果セット
     * @throws SQLRuntimeException
     *             SQL例外が発生した場合
     */
    public static ResultSet executeQuery(Statement statement, String sql)
            throws SQLRuntimeException {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException ex) {
            throw new SQLRuntimeException(ex);
        }
    }

    /**
     * クローズします。
     * 
     * @param statement
     *            ステートメント
     * @throws SQLRuntimeException
     *             SQL例外が発生した場合
     */
    public static void close(Statement statement) throws SQLRuntimeException {
        if (statement == null) {
            return;
        }
        try {
            statement.close();
        } catch (SQLException ex) {
            throw new SQLRuntimeException(ex);
        }
    }
}