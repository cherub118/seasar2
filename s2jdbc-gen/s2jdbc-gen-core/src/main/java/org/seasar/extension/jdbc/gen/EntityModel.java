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
package org.seasar.extension.jdbc.gen;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import org.seasar.framework.util.ClassUtil;

/**
 * @author taedium
 * 
 */
public class EntityModel {

    protected SortedSet<String> importPackageNameSet = new TreeSet<String>();

    protected String className;

    protected String packageName;

    protected String shortClassName;

    protected EntityDesc entityDesc;

    protected boolean tableQualified;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getShortClassName() {
        return shortClassName;
    }

    public void setShortClassName(String shortClassName) {
        this.shortClassName = shortClassName;
    }

    public SortedSet<String> getImportPackageNameSet() {
        return Collections.unmodifiableSortedSet(importPackageNameSet);
    }

    public void addImportPackageName(String name) {
        importPackageNameSet.add(name);
    }

    public EntityDesc getEntityDesc() {
        return entityDesc;
    }

    public void setEntityDesc(EntityDesc entityDesc) {
        this.entityDesc = entityDesc;
    }

    public boolean isTableQualified() {
        return tableQualified;
    }

    public void setTableQualified(boolean tableQualified) {
        this.tableQualified = tableQualified;
    }

    public boolean isLengthAvailable(AttributeDesc attributeDesc) {
        return !isNumber(attributeDesc) && attributeDesc.getLength() > 0;
    }

    public boolean isPrecisionAvailable(AttributeDesc attributeDesc) {
        return isNumber(attributeDesc) && attributeDesc.getPrecision() > 0;
    }

    public boolean isScaleAvailable(AttributeDesc attributeDesc) {
        Class<?> clazz = ClassUtil.getWrapperClassIfPrimitive(attributeDesc
                .getAttributeClass());
        return clazz == BigDecimal.class || clazz == Float.class
                || clazz == Double.class;
    }

    protected boolean isNumber(AttributeDesc attributeDesc) {
        Class<?> clazz = ClassUtil.getWrapperClassIfPrimitive(attributeDesc
                .getAttributeClass());
        return Number.class.isAssignableFrom(clazz);
    }
}