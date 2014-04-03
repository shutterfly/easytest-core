package org.easetech.easytest.loader;

import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CSVDataLoaderTest {

    @Test
    public void writeOutputData_should_not_throw_exceptions_when_currentRowData_is_missing_values(){
        Map<String, Object> currentRowData = Collections.<String, Object>emptyMap();
        String[] finalValues = {};
        String[] dataKeys = {};
        CSVDataLoader.writeOutputData(currentRowData,
            finalValues,
            dataKeys);
        assertTrue(currentRowData.isEmpty());
    }
}
