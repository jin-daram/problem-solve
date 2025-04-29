import java.util.Arrays;

class Solution {
   private String START_CITY = "ICN";

    private String rawAnswer = "";

    public String[] solution(String[][] tickets) {
        boolean[] usingTickets = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> { // 2차원 배열을 문자열 오름차순으로 정렬
            int first = a[0].compareTo(b[0]);
            if (first != 0) return first;
            return a[1].compareTo(b[1]);
        });

        for (int i=0; i<tickets.length; i++) {
            if (tickets[i][0].equals(START_CITY)) {
                boolean success = dfs(tickets, tickets[i], "ICN", 0, usingTickets, i);
                if (!success) usingTickets = new boolean[tickets.length];
                if (success) break;
            }
        }
        String[] answer = ans.split(" ");
        return answer;
    }

    public boolean dfs(String[][] tickets, String[] ticket, String route, int index, boolean[] visited, int number) {
        boolean[] copy = visited.clone();
        copy[number] = true;
        String destination = ticket[1];
        String spaceDestination = " " + destination;

        if (tickets.length - 1 == index) {
            rawAnswer = route + spaceDestination;
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(destination) && !copy[i]) {
                boolean result = dfs(tickets, tickets[i], (route + spaceDestination), index + 1, copy, i);
                if (result) return true;
            }
        }
        return false;
    }


}