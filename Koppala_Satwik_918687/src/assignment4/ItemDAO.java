package assignment4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ItemDAO {
	private Connection connection =datasource.getConnection();

	public void additem(Item item) { 
		PreparedStatement ps;
		String sql="insert into item values(?,?,?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setDouble(2, item.getPrice());
			ps.setString(3, item.getType());
			int rec=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		    }
		}

	public void bulkCopy(List<Item> itemList)	{
		for (Item item : itemList) {
			additem(item);
		}
	}
	
	public List<Item> findItem(String type)	{
		
		String sql="select * from item where Type=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
            ps.setString(1, type);
			ResultSet rs=ps.executeQuery();
			List<Item> items= new ArrayList<>();
			while(rs.next())
			{
				items.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
			}
			return items;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return null;
	}
	
	public List<Item> finditem(Double price) {
		
		String sql="select * from item where Price=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setDouble(1,price);
			ResultSet rs=ps.executeQuery();
			List<Item> items= new ArrayList<>();
			while(rs.next())
			{
				items.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
			}
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}