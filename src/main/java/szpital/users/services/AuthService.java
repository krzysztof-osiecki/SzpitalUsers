package szpital.users.services;

import javaslang.Tuple;
import javaslang.Tuple2;

import java.util.Arrays;
import java.util.List;

public class AuthService {

  private static List<Tuple2<String, String>> USERS = Arrays.asList(Tuple.of("admin", "xx"), Tuple.of("user1", "yyy"));


  public static boolean validate(String user, String password) {
    return USERS.contains(Tuple.of(user, password));
  }

//	public static boolean validate(String user, String password) {
//		Connection con = null;
//		PreparedStatement ps = null;
//
//		try {
//			con = DataConnect.getConnection();
//			ps = con.prepareStatement("Select uname, password from Users where uname = ? and password = ?");
//			ps.setString(1, user);
//			ps.setString(2, password);
//
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) {
//				return true;
//			}
//		} catch (SQLException ex) {
//			System.out.println("Login error -->" + ex.getMessage());
//			return false;
//		} finally {
//			DataConnect.close(con);
//		}
//		return false;
//	}
}