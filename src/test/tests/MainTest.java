package tests;

import categoryInterface.MyCategories;
import generators.FileGenerator;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainTest {
    @BeforeClass
    public static void setUp() throws IOException {
        Files.createDirectory(Paths.get("test"));
    }

    @AfterClass
    public static void tearDown() throws IOException {
        File testDir = new File("test");
        FileUtils.deleteDirectory(testDir);
    }

    //@Parameterized.Parameters(name = "filename")
    @Test
    @Category(MyCategories.PositiveTests.class)
    public void createFileTest() throws IOException {
        File f = new File("filename");
        Assert.assertTrue(f.createNewFile());
    }

    @Test
    @Category(MyCategories.NegativeTests.class)
    public void fileNotExistsTest() {
        File f = new File("unknownFile");
        Assert.assertFalse(f.exists());
    }

    @Test
    public void generateFileTest() throws Exception {
        String fileName = FileGenerator.create("test");
        Assert.assertTrue((new File(fileName)).exists());
    }
}
