package edu.berkeley.aep;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jhumble on 4/9/15.
 */
public class GraphTest {

    static Node a = new Node();
    static Node b = new Node();
    static Node c = new Node();
    static Node d = new Node();
    static Node e = new Node();
    static Node f = new Node();
    static Node g = new Node();
    static Node h = new Node();
    static Node i = new Node();

    static {
        h.addChild(b);
        b.addChild(c);
        b.addChild(a);
        a.addChild(f);
        c.addChild(d);
        c.addChild(e);
        c.addChild(e);
        d.addChild(e);
        e.addChild(b);
        e.addChild(i);
    }

    @Test
    public void nodeShouldReachSelf() {
        Node node = new Node();
        assertTrue(node.canReach(node));
    }

    @Test
    public void nodeShouldReachChild() {
        assertTrue(h.canReach(b));
    }

    @Test
    public void nodeShouldReachDescendant() {
        assertTrue(h.canReach(f));
    }

    @Test
    public void nodeShouldNotReachUnreachableNode() {
        assertFalse(h.canReach(g));
    }
}
