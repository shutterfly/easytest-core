package org.easetech.easytest.loader;

import junit.framework.AssertionFailedError;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoaderFactoryTest {

    @Test
    public void should_return_a_CSVDataLoader_for_CSV(){
        assertTrue(LoaderFactory.getLoader(LoaderType.CSV) instanceof CSVDataLoader);
    }

    @Test
    public void should_return_a_CSVJSONDataLoader_for_CSV_JSON(){
        assertTrue(LoaderFactory.getLoader(LoaderType.CSV_JSON) instanceof CSVJSONDataLoader);
    }

    @Test
    public void should_return_an_ExcelDataLoader_for_EXCEL(){
        assertTrue(LoaderFactory.getLoader(LoaderType.EXCEL) instanceof ExcelDataLoader);
    }

    @Test
    public void should_return_an_XMLDataLoader_for_XML(){
        assertTrue(LoaderFactory.getLoader(LoaderType.XML) instanceof XMLDataLoader);
    }

    @Test(expected = AssertionFailedError.class)
    public void should_fail_when_unsupported_LoaderType_is_provided(){
        LoaderFactory.getLoader(null);
    }
}
