/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
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
package org.seasar.extension.sql.cache;

import junit.framework.TestCase;

import org.seasar.extension.sql.Node;
import org.seasar.extension.sql.context.SqlContextImpl;

/**
 * @author higa
 * 
 */
public class NodeCacheTest extends TestCase {

    @Override
    protected void tearDown() throws Exception {
        NodeCache.clear();
    }

    /**
     * 
     */
    public void testGetNode() {
        Node node = NodeCache.getNode(getClass().getName(), null);
        assertNotNull(node);
        SqlContextImpl ctx = new SqlContextImpl();
        node.accept(ctx);
        assertEquals("standard", ctx.getSql());
        assertSame(node, NodeCache.getNode(getClass().getName(), null));
    }

    /**
     * 
     */
    public void testGetNode_dbmsName() {
        Node node = NodeCache.getNode(getClass().getName(), "oracle");
        assertNotNull(node);
        SqlContextImpl ctx = new SqlContextImpl();
        node.accept(ctx);
        assertEquals("oracle", ctx.getSql());
        assertSame(node, NodeCache.getNode(getClass().getName(), "oracle"));
    }

    /**
     * 
     */
    public void testGetNode_dbmsName_notFound() {
        Node node = NodeCache.getNode(getClass().getName(), "xxx");
        assertNotNull(node);
        SqlContextImpl ctx = new SqlContextImpl();
        node.accept(ctx);
        assertEquals("standard", ctx.getSql());
        assertSame(node, NodeCache.getNode(getClass().getName(), "xxx"));
    }

    /**
     * 
     */
    public void testGetNode_notFound() {
        assertNull(NodeCache.getNode("notFound", null));
    }
}