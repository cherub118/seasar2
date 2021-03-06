/*
 * Copyright 2004-2015 the Seasar Foundation and the Others.
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
package org.seasar.extension.jdbc.gen.desc;

import org.seasar.extension.jdbc.EntityMeta;

/**
 * {@link PrimaryKeyDesc 主キー記述}のファクトリです。
 * 
 * @author taedium
 */
public interface PrimaryKeyDescFactory {

    /**
     * 主キー記述を返します。
     * 
     * @param entityMeta
     *            エンティティメタデータ
     * @return 存在する場合は主キー記述、存在しない場合は{@code null}
     */
    PrimaryKeyDesc getPrimaryKeyDesc(EntityMeta entityMeta);

}