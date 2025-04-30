package org.example;

import java.util.*;

public class Solution_64064 {

    Set<Set<String>> ways = new HashSet();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(List.of(user_id), List.of(banned_id), new HashSet<>());
        return ways.size();
    }

    public boolean compare(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;

        for (int i=0; i<userId.length(); i++) {
            char bannedIdChar = bannedId.charAt(i);
            if (bannedIdChar != '*' && userId.charAt(i) != bannedIdChar)
                return false;
        }
        return true;
    }

    public void dfs(List<String> userId, List<String> bannedId, Set<String> bannedUsers) {
        if (bannedId.isEmpty()) {
            ways.add(bannedUsers);
            return;
        }

        for(int i=0; i<userId.size(); i++) {
            String user = userId.get(i);
            String bannedUser = bannedId.get(0);
            if (compare(user, bannedUser)) {
                List<String> newUserId = new ArrayList<>(userId);
                List<String> newBannedId = new ArrayList<>(bannedId);
                Set<String> newPath = new HashSet<>(bannedUsers);

                newUserId.remove(i);
                newBannedId.remove(0);
                newPath.add(user);

                dfs(newUserId, newBannedId, newPath);
            }
        }
    }
}
