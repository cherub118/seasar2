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
package org.seasar.extension.jdbc.gen.version;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.seasar.extension.jdbc.gen.DdlVersion;
import org.seasar.extension.jdbc.gen.util.CloseableUtil;
import org.seasar.extension.jdbc.gen.util.VersionUtil;
import org.seasar.framework.exception.IORuntimeException;
import org.seasar.framework.log.Logger;
import org.seasar.framework.util.FileOutputStreamUtil;
import org.seasar.framework.util.TextUtil;

/**
 * {@link DdlVersion}の実装クラスです。
 * 
 * @author taedium
 */
public class DdlVersionImpl implements DdlVersion {

    /** ロガー */
    protected Logger logger = Logger.getLogger(DdlVersionImpl.class);

    /** DDLファイル */
    protected File file;

    /** バージョン番号 */
    protected Integer versionNo;

    /**
     * インスタンスを構築します。
     * 
     * @param file
     *            ファイル
     */
    public DdlVersionImpl(File file) {
        if (file == null) {
            throw new NullPointerException("file");
        }
        this.file = file;
    }

    public int getVersionNo() {
        if (versionNo != null) {
            return versionNo;
        }
        if (!file.exists()) {
            logger.log("IS2JDBCGen0003", new Object[] { file.getPath() });
            return 0;
        }
        String value = TextUtil.readUTF8(file).trim();
        return VersionUtil.toInt(file.getPath(), value);
    }

    public void setVersionNo(int versionNo) {
        OutputStream os = FileOutputStreamUtil.create(file);
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(os, "UTF-8");
            writer.write(String.valueOf(versionNo));
        } catch (IOException e) {
            throw new IORuntimeException(e);
        } finally {
            CloseableUtil.close(writer);
        }
        this.versionNo = null;
    }
}