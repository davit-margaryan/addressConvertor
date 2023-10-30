package org.example;

import java.util.HashMap;
import java.util.Map;

public class AddressConverterWithoutRegex {
    private static Map<String, String> abbreviationMap;

    static {
        abbreviationMap = new HashMap<>();
        abbreviationMap.put("Ave", "Avenue");
        abbreviationMap.put("Ave.", "Avenue");
        abbreviationMap.put("St", "Street");
        abbreviationMap.put("St.", "Street");
        abbreviationMap.put("Str", "Street");
        abbreviationMap.put("Str.", "Street");
    }

    public static String convert(String address) {
        String[] parts = address.split(",");
        StringBuilder expandedAddress = new StringBuilder();

        for (String part : parts) {
            String[] words = part.trim().split("\\s+");
            StringBuilder expandedPart = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                String replacement = abbreviationMap.get(word);
                if (replacement != null) {
                    expandedPart.append(replacement);
                } else {
                    expandedPart.append(word);
                }
                if (i < words.length - 1) {
                    expandedPart.append(" ");
                }
            }
            expandedAddress.append(expandedPart);
            if (!part.equals(parts[parts.length - 1])) {
                expandedAddress.append(",");
            }
        }

        return expandedAddress.toString();
    }
}
