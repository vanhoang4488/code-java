package demo.ctvftech.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import demo.ctvftech.attributes.SessionATT;
import demo.ctvftech.dto.User;
import demo.ctvftech.services.EmployeesService;

@RestController
@RequestMapping("/user")
public class UserAPI {

	@Autowired
	private EmployeesService service;

	@Autowired
	private HttpSession session;

	private String avatarDefault;

	@GetMapping("/login/")
	public ModelAndView login() {

		return new ModelAndView("test");
	}

	// chức năng đăng nhập.
	@PostMapping(value = "/login/")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
			@RequestBody User user) throws Exception {

//		String username = params.get("username");
//		
//		String password = service.findUser(username);
//
//		String reversePassword = service.encodingPassword(params.get("password"));
//
//		if (!password.equals(reversePassword)) {
//
//			request.setAttribute("notice", "thông tin tài khoản hoặc mật khẩu không chính xác");
//
//			return new ModelAndView("login");
//		}
//
//		User user = new User(username, password, service.findIdByUsername(username));
//		user.setId(service.findIdByUsername(username));
//		
//		if (params.get("rememberPassword").equals("REMEMBER")) 
//			CookieATT.storeUserInCookie(response, user);
//		else 
//			CookieATT.deleteUserInCookie(response);
//		
//		SessionATT.storeUserInSession(session, user);

		return new ModelAndView("home");
	}

	@GetMapping("/changePassword")
	public ModelAndView changePassword() {
		
		return new ModelAndView("changePassword");
	}
	
	@PostMapping("/changePassword/")
	public ModelAndView changePassword(HttpServletRequest request, @RequestParam(value = "username") String username,
			@RequestParam(value = "oldPass") String oldPass, @RequestParam(value = "newPass") String newPass)
			throws Exception {

		String password = service.findUser(username);

		String reversePassword = service.encodingPassword(oldPass);

		if (!password.equals(reversePassword)) {
		
			request.setAttribute("notice", "mật khẩu cũ không chính xác");
			
			return new ModelAndView("changePassword");
		}

		service.saveUser(username, reversePassword);

		return new ModelAndView("login");
	}

	@GetMapping("/forgetpassword/{username}")
	public ModelAndView forgetpassword() {
		
		return new ModelAndView("forgetPassword");
	}
	
	// chức năng quên mật khẩu.
	@PutMapping("/forgetpassword/{username}")
	public ModelAndView forgetpassword(@PathVariable(value = "username") String username) {

		return new ModelAndView("login");
	}

	// chức năng đăng xuất.
	@GetMapping("/logout/")
	public ModelAndView logout() {

		SessionATT.getChecked(session);

		SessionATT.storeUserInSession(session, null);

		return new ModelAndView("login");
	}

	// chức năng đăng ký tài khoản mới dành riêng cho quản trị viên.
	@PostMapping("/admin/register/")
	public ModelAndView registerUser(HttpServletRequest request, @RequestBody User user) throws Exception {

		if (!service.checkId("EmployeesEntity", user.getId()))
			request.setAttribute("notice", "Thông tin nhân viên chưa đăng ký");

		else if (service.findUser(user.getUsername()) != null)
			request.setAttribute("notice", "Tên tài khoản đã tồn tại");

		if (user.getAvatarUrl() == null)
			user.setAvatarUrl(avatarDefault);

		// if(!service.saveUser(session, user)) return "failed";

		return new ModelAndView("register");
	}
	 
}
