package org.easetech.easytest.loader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataLoaderUtilTest {

    @Test
    public void CSV_loader_should_resolve_for_file_extension_csv(){
        assertEquals(LoaderType.CSV, DataLoaderUtil.resolveFileExtension("csv"));
    }

    @Test
    public void CSV_JSON_loader_should_resolve_for_file_extension_csv(){
        assertEquals(LoaderType.CSV_JSON, DataLoaderUtil.resolveFileExtension("csv-json"));
    }

    @Test
    public void Excel_loader_should_resolve_for_file_extension_xls(){
        assertEquals(LoaderType.EXCEL, DataLoaderUtil.resolveFileExtension("xls"));
    }

    @Test
    public void XML_loader_should_resolve_for_file_extension_xml(){
        assertEquals(LoaderType.XML, DataLoaderUtil.resolveFileExtension("xml"));
    }

    @Test
    public void Custom_loader_should_resolve_for_unknown_file_extensions(){
        for (String extension: new String[] { null, "", "unknown"}) {
            assertEquals(LoaderType.CUSTOM, DataLoaderUtil.resolveFileExtension(extension));
        }
    }

}
