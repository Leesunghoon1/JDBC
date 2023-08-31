package JDBC;

import java.util.List;

public interface DAO {

	int insert(Product p);

	List<Product> selectList();

	Product selectOne(int pno);

	int selectModify(Product p);

	int selectRemove(int pno);
	
	

}
