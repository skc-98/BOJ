class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String[] r = routes[i].split(" ");
            int dx = 0, dy = 0;
            if (r[0].equals("N")) dx = -1;
            else if (r[0].equals("S")) dx = 1;
            else if (r[0].equals("W")) dy = -1;
            else if (r[0].equals("E")) dy = 1;
            int nx = x, ny = y;
            boolean check = true;
            for (int j = 0; j < Integer.parseInt(r[1]); j++) {
                nx += dx;
                ny += dy;
                if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length() || park[nx].charAt(ny) == 'X') {
                    check = false;
                    break;
                }
            }
            if (check) {
                x = nx;
                y = ny;
            }
        }
        return new int[]{x, y};
    }
}