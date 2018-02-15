package ro.certejan.dbunittest;

import java.io.FileOutputStream;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbunitTestApplicationTests {

    @Autowired
    private DataSource dataSource;

    // http://archive.oreilly.com/pub/post/dbunit_made_easy.html

    @Test
    public void extractTestData() throws Exception {
        IDatabaseConnection connection = new DatabaseConnection(dataSource.getConnection());
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("FOO", "SELECT * FROM FOO WHERE ID = 1");
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("./partial-dataset.xml"));
    }

    @Test
    public void testDummy() throws Exception {
        IDatabaseConnection connection = new DatabaseConnection(dataSource.getConnection());
        ITable table = connection.createDataSet().getTable("FOO");
        System.out.println(table.getRowCount());
    }

}
