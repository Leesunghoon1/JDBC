package JDBC;

import java.util.List;

public class ProdcutServiceImpl implements Service {
	
	private DAO dao;
	
	public ProdcutServiceImpl() {
		dao = new ProdcutDAOImpl(); //구현체
	}

	@Override
	public int register(Product p) {
		// 실제 구현 영역
		System.out.println("register_service success!!");
		// dao에서 사용되는 메서드명 DB 구문과 비슷하게 하는것이 일반적
		return dao.insert(p);
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		System.out.println("list_service success!!");
		return dao.selectList();
	}

	@Override
	public Product detail(int pno) {
		System.out.println("list_service success!!");
		return dao.selectOne(pno);
	}

	@Override
	public int modify(Product p) {
		System.out.println("list_service success!!");
		return dao.selectModify(p);
	}

	@Override
	public int remove(int pno) {
		System.out.println("list_service success!!");
		return dao.selectRemove(pno);
	}
	
	

}
