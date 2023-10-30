package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressConverterWithRegex {

    public static String convert(String input) {
        String regex = "\\b(Ave|St|Str)\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String abbreviation = matcher.group(1);
            String replacement = getReplacement(abbreviation);
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString().replaceAll("\\.", "");
    }

    private static String getReplacement(String abbreviation) {
        return switch (abbreviation.toLowerCase()) {
            case "ave" -> "Avenue";
            case "st" -> "Street";
            case "str" -> "Street";
            default -> abbreviation;
        };
    }
}
