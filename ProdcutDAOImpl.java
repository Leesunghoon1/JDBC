package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdcutDAOImpl implements DAO {
	
	
	//DB 연결
	private Connection conn;
	//Sql 구문을 실행시키는 기능을 갖는 객체
	private PreparedStatement pst;
	private String query = ""; //쿼리 구문 저장
	
	public ProdcutDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	//SQL 구문 처리
	
	@Override
	public int insert(Product p) {
		// 실제연결
		System.out.println("insert DAO success!!");
		query = "insert into product(pname, price, madeby) values(?,?,?)";
		try {
			//query구문을 받고 pst에 전달
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			//insert, update, delete => executeUpdate() in타입으로 return 
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Product> selectList() {
		// TODO Auto-generated method stub
		System.out.println("insert DAO success!!");
		query = "select * from product Order by pno desc ";
		List<Product> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//pno, pname, price
				list.add(new Product(
						rs.getString("pname"),
						rs.getInt("pno"),
						rs.getInt("price"))); 
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("selectList error");
			e.printStackTrace();
		}
		return null;
	}
	
	public Product selectOne(int pno) {
		System.out.println("detail_DAO success!!");
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby"));
			}
		} catch (Exception e) {
			System.out.println("selectcOne erro");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selectModify(Product p) {
		
		System.out.println("update DAO success!!");
		query =  "update product SET pname = ?, price = ?, madeby = ? WHERE pno = ?";
		try {
			//query구문을 받고 pst에 전달
			pst = conn.prepareStatement(query);
			
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			//insert, update, delete => executeUpdate() in타입으로 return 
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int selectRemove(int pno) {
		System.out.println("insert DAO success!!");
		query =  "delete from product where pno = ?";
		try {
			//query구문을 받고 pst에 전달
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			//insert, update, delete => executeUpdate() in타입으로 return 
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}
}
