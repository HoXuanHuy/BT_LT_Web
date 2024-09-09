package webhxh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webhxh.config.DBConnectMySQL;
import webhxh.dao.IUserDao;
import webhxh.model.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public PreparedStatement findMissingIdStmt = null;

	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select* from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("email"), rs.getString("password"), rs.getString("image")));
			}
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE id = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id); // Thiết lập giá trị của tham số id trong câu truy vấn
			rs = ps.executeQuery();

			if (rs.next()) {
				// Nếu tìm thấy user với id tương ứng, trả về đối tượng UserModel
				return new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("email"), rs.getString("password"), rs.getString("image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users(id,fullname, username, email, password,  image) VALUES (?,?,?,?,?,?)";

//		try {
//			conn = super.getDatabaseConnection();
//			ps = conn.prepareStatement(sql);
//
//			ps.setInt(1, user.getId());
//			ps.setString(2, user.getUsername());
//			ps.setString(3, user.getEmail());
//			ps.setString(4, user.getPassword());
//			ps.setString(5, user.getImage());
//			ps.setString(6, user.getFullname());
//
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

		try {
			conn = super.getDatabaseConnection();
			// Tìm và chèn dữ liệu vào ID trống
			String findMissingIdSQL = "SELECT t1.id + 1 AS missing_id " + "FROM ( " + "    SELECT id FROM users "
					+ "    UNION ALL " + "    SELECT 0 AS id " + ") AS t1 " + "LEFT JOIN users t2 ON t1.id + 1 = t2.id "
					+ "WHERE t2.id IS NULL " + "ORDER BY missing_id " + "LIMIT 1;";

			findMissingIdStmt = conn.prepareStatement(findMissingIdSQL);

			ps = conn.prepareStatement(sql);
			rs = findMissingIdStmt.executeQuery();

			while (rs.next()) {
				int missingId = rs.getInt("missing_id");

				// Chèn thông tin vào ID trống
				ps.setInt(1, missingId);
				ps.setString(2, user.getFullname());
				ps.setString(3, user.getUsername());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getPassword());
				ps.setString(6, user.getImage());

				ps.executeUpdate();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public boolean CheckEmailExist(String Email) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String query = "select * from users WHERE email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, Email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean CheckUserExist(String User) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String query = "select * from users WHERE username = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, User);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public UserModel findbyUser(String User) {
		// TODO Auto-generated method stub
		String sql = "select * from users WHERE username = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, User);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("email"), rs.getString("password"), rs.getString("image"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

//	public static void main(String[] args) {
//
//		UserDaoImpl userDao = new UserDaoImpl();
//		
//		
//		
//		UserModel user=userDao.findbyUser("Huy");
//		System.out.println(user);
//
////		userDao.insert(new UserModel("XHuy", "huy@gmail.com", "1234", "Duy Khai", "null"));
////
////		List<UserModel> list = userDao.findAll();
////
////		for (UserModel user : list) {
////			System.out.println(user);
////		}
//
////		UserModel user1 = userDao.findById(1);
////	    if (user1 != null) {
////	        System.out.println(user1);
////	    } else {
////	        System.out.println("User not found!");
////	    }
//	}

}
