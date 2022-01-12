package study.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDAO {

	@Autowired
	private DataSource  ds; //LOOSE  COUPLING --- we are talking to interface , the impl class may change!!
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public DataSource getDs() {
		return ds;
	}
	
	
	public void addBook(int id, int cost, String name)
	{
		try {
		Connection  con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into book values(?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setInt(2, cost);
		pstmt.setString(3, name);
		pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


}
