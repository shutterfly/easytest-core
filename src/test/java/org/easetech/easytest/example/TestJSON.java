package org.easetech.easytest.example;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.annotation.Repeat;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths= "jsonBasedData.csv-json")
public class TestJSON {

    @Test
    @Repeat(times=3)
    public void testJSONObjectCSV(@Param(name="Item")Item item , LibraryId libId){
        assertNotNull(item);
        assertEquals(Long.valueOf(23), item.getItemId().getId());
        assertEquals(Long.valueOf(34), libId.getId());
    }
    

    @Test
    @Repeat(times=3)
    @DataLoader(filePaths="jsonBasedData.xls")
    public void testJSONObject(@Param(name="Item")Item item , @Param(name="Purpose") String purpose){
        assertNotNull(item);

        assertNotNull(item.getItemId().getId());
        assertThat(purpose, containsString("Test"));
    }    

}
