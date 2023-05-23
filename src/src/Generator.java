public class Generator {
    private static int ASCII_symbols_start = 33;
    private static int ASCII_symbols_end = 47;
    private static int ASCII_num_start = 48;
    private static int ASCII_num_end = 58;
    private static int ASCII_upper_start = 65;
    private static int ASCII_upper_end = 91;
    private static int ASCII_lower_start = 97;
    private static int ASCII_lower_end = 123;






    public static String generate(int length, boolean symbols) {
        String pass = "";
        for(int i = 0; i < length; i++) {
            if(symbols) {
                int pw_part = StdRandom.uniformInt(ASCII_symbols_start, ASCII_lower_end);
                pass = pass + (char) pw_part;
            } else {
                int mode = StdRandom.uniformInt(3);
                if(mode == 0) {
                    int pw_part = StdRandom.uniformInt(ASCII_upper_start, ASCII_upper_end);
                    pass = pass + (char) pw_part;
                } else if (mode == 1) {
                    int pw_part = StdRandom.uniformInt(ASCII_num_start, ASCII_num_end);
                    pass = pass + (char) pw_part;
                } else {
                    int pw_part = StdRandom.uniformInt(ASCII_lower_start, ASCII_lower_end);
                    pass = pass + (char) pw_part;
                }
            }
        }
        return pass;
    }
}
