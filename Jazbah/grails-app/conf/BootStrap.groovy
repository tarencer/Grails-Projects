import terry.world.twitter.auth.Person
import terry.world.twitter.auth.Authority
class BootStrap {

	
    def init = { servletContext ->
		if(!Person.count()){
			
			Authority userRole = new Authority(authority:"ROLE_ADMIN")
			
			userRole.save()
			
			Person admin = new Person(fullname:"Tarsicius Rodrigues",
				username:"trodri",
				password:"password")
			
			admin.setEnabled(true);
			admin.save()
			admin.getAuthorities().add(userRole)
			admin.save()
			
			Person user1 = new Person(fullname:"Anafay Goes",
					username:"anoes",
					password:"1")
			user1.setEnabled(true)
			user1.save()
			user1.getAuthorities().add(userRole)
			user1.save()
		}
    }
    def destroy = {
    }
}
