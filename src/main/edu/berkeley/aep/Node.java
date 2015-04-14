package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

// Understands its relationship to its neighbors
public class Node {

    Collection<Node> children = new ArrayList<Node>();

    public void addChild(Node child) {
        children.add(child);
    }

    public boolean canReach(Node node) {
        return canReach(node, new HashSet<Node>());
    }

    private boolean canReach(Node node, HashSet<Node> visited) {
        if (node == this) return true;
        if (!visited.add(this)) return false; // if we've already seen this node, terminate
        for (Node child : children) {
            if (child.canReach(node, visited)) {
                return true;
            }
        }
        return false;
    }
}
