package by.trjava.trips.chekun.domain.util.parser;

public final class Parser {

    //regex clean = or : or , or ; from line
    private static final String REGEX_TO_CLEAN_FROM_COLON_COMMA_EQUALS_SEMICOLON = "=|:|,|;";
    //regex for cleaning all spaces in line
    private static final String CLEAR_ALL_SPACES = " +";
    private static final String SPACE = " ";
    ///////////////////////

    public static String[] parseStringIntoArgsArray(String line) {
        line = line.replaceAll(REGEX_TO_CLEAN_FROM_COLON_COMMA_EQUALS_SEMICOLON, SPACE);
        line = line.trim().replaceAll(CLEAR_ALL_SPACES, SPACE);
        return line.split(SPACE);
    }

    private Parser() {
    }
}
