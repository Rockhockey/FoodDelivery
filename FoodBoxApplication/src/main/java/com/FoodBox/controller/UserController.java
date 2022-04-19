import org.springframework.web.bind.annotation.RestController;

import com.FoodBox.model.Users;
import com.FoodBox.service.UserService;
//add to gh
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	List<Users> users = new ArrayList<Users>();
	
	//--------------------------- RESTful API for Retrieval operations ---------------------------------- //
	@GetMapping("allUsers")
	List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<Users> getUserById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<Users>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("{UserName}")
	public ResponseEntity<Users> getUserByUsername(@PathVariable("UserName") String userName){
		return new ResponseEntity<Users>(userService.getUserByUsername(userName), HttpStatus.OK);
	}
	
	
}