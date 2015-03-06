package restDemo;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAll(){
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public User show(@PathVariable String id){
		return repo.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public User create(@RequestBody User user){
		return repo.save(user);
	}	
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public void delete(@PathVariable String id){
		repo.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="{id}")
	public User update(@PathVariable String id, @RequestBody User user){
		User update = repo.findOne(id);
		update.setAddress(user.getAddress());
		update.setEmail(user.getEmail());
		update.setFirstName(user.getFirstName());
		update.setLastName(user.getLastName());
		update.setPhoneNumber(user.getPhoneNumber());
		
		return repo.save(update);
	}
}