package webhxh.model;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String fullname;
	private String username;
	private String email;
	private String password;
	private String image;
	private String phone;
	private int roleid;
	private Date createday;
	
	
	public UserModel() {
		super();
	}


	public UserModel(int id, String fullname, String username, String email, String password, String image,
			String phone, int roleid, Date createday) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.image = image;
		this.phone = phone;
		this.roleid = roleid;
		this.createday = createday;
	}
	
	


	public UserModel(String fullname, String username, String email, String password, String image, String phone,
			int roleid, Date createday) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.image = image;
		this.phone = phone;
		this.roleid = roleid;
		this.createday = createday;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getRoleid() {
		return roleid;
	}


	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}


	public Date getCreateday() {
		return createday;
	}


	public void setCreateday(Date createday) {
		this.createday = createday;
	}


	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullname=" + fullname + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", image=" + image + ", phone=" + phone + ", roleid=" + roleid + "]";
	}
	
	
	
	
	
	
	

}
