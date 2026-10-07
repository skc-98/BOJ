class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = Integer.parseInt(video_len.substring(0, 2)) * 60 + Integer.parseInt(video_len.substring(3));
        int p = Integer.parseInt(pos.substring(0, 2)) * 60 + Integer.parseInt(pos.substring(3));
        int s = Integer.parseInt(op_start.substring(0, 2)) * 60 + Integer.parseInt(op_start.substring(3));
        int e = Integer.parseInt(op_end.substring(0, 2)) * 60 + Integer.parseInt(op_end.substring(3));
        if (s <= p && p <= e) p = e;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("prev")) p = Math.max(0, p - 10);
            else p = Math.min(len, p + 10);
            if (s <= p && p <= e) p = e;
        }
        return String.format("%02d:%02d", p / 60, p % 60);
    }
}