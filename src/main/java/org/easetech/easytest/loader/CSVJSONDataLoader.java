package org.easetech.easytest.loader;

/**
 * CSVJSONDataLoader provides a means to load JSON from CSV files.  CSV files must be
 * specially-constructed, as commas are a natural part of JSON.
 *
 * The following character replacements will occur when data is ready from the file:
 *
 * <ol>
 *     <li>single-quote (') replaced by double-quote (")</li>
 *     <li>ampersand (&) replaced by (,)</li>
 * </ol>
 */
public class CSVJSONDataLoader extends CSVDataLoader {

    /**
     * Normalize the string that is read from a CSV file for JSON conversion if required
     *
     * @param value the string to normalize
     * @return the normalized string
     */
    protected String normalize(String value) {
        return value.replaceAll(SINGLE_QUOTE, DOUBLE_QUOTE).replaceAll(AMPERSAND, COMMA);
    }

}
