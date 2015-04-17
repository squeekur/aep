package edu.berkeley.aep;

import java.util.*;

/**
 * Created by jhumble on 3/19/15.
 */
public class GolfPartyAssigner {

    private final List<Integer> parties;
    private static int MAX_PARTY_SIZE = 4;

    public GolfPartyAssigner(Integer[] parties) {
        this.parties = null == parties ? new ArrayList() : new ArrayList(Arrays.asList(parties));
    }

    public int assign() {
        if (parties.size() == 0) return 0;
        int groups = 0;
        do {
            groups++;
        } while (fillGroup());
        return groups;
    }

    public boolean fillGroup() {
        int currentPartySize = 0;
        for (Iterator<Integer> iterator = parties.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            if (next > MAX_PARTY_SIZE) {
                throw new RuntimeException("You can't have more than " + MAX_PARTY_SIZE + "people in a party");
            }
            if (currentPartySize + next <= MAX_PARTY_SIZE) {
                currentPartySize += next;
                iterator.remove();
            }
        }
        return !parties.isEmpty();
    }

}
