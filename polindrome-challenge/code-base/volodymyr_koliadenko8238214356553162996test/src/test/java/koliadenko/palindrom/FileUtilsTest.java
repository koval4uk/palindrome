/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koliadenko.palindrom;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author vova
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Files.class})
public class FileUtilsTest {

    public FileUtilsTest() {
    }

    @Test
    public void testReadFileAsString() {
        System.out.println("readFileAsString");
        String filename = "abracadabra";
        String expResult = "";
        String result = FileUtils.readFileAsString(filename);
        assertEquals(expResult, result);

    }

    

}
