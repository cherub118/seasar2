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
package org.seasar.extension.jdbc.gen.meta;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.seasar.extension.jdbc.EntityMeta;
import org.seasar.extension.jdbc.meta.ColumnMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.EntityMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.PropertyMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.TableMetaFactoryImpl;
import org.seasar.framework.convention.PersistenceConvention;
import org.seasar.framework.convention.impl.PersistenceConventionImpl;
import org.seasar.framework.util.ClassUtil;
import org.seasar.framework.util.ResourceUtil;

import static org.junit.Assert.*;

/**
 * @author taedium
 * 
 */
public class EntitiesReaderImplTest {

    private java.io.File rootDir;

    private String packageName;

    private EntityMetaFactoryImpl entityMetaFactory;

    @Before
    public void before() {
        rootDir = ResourceUtil.getBuildDir(getClass());
        packageName = ClassUtil.splitPackageAndShortClassName(getClass()
                .getName())[0];
        PersistenceConvention pc = new PersistenceConventionImpl();
        ColumnMetaFactoryImpl cmf = new ColumnMetaFactoryImpl();
        cmf.setPersistenceConvention(pc);
        PropertyMetaFactoryImpl pmf = new PropertyMetaFactoryImpl();
        pmf.setPersistenceConvention(pc);
        pmf.setColumnMetaFactory(cmf);
        TableMetaFactoryImpl tmf = new TableMetaFactoryImpl();
        tmf.setPersistenceConvention(pc);
        entityMetaFactory = new EntityMetaFactoryImpl();
        entityMetaFactory.setPersistenceConvention(pc);
        entityMetaFactory.setPropertyMetaFactory(pmf);
        entityMetaFactory.setTableMetaFactory(tmf);
    }

    @Test
    public void testRead() throws Exception {
        EntitiesReaderImpl reader = new EntitiesReaderImpl(rootDir,
                packageName, "A.*", entityMetaFactory);
        List<EntityMeta> list = reader.read();
        assertEquals(2, list.size());
    }
}
