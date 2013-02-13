import terry.world.jazbah.*
class BootStrap {

	def init = { servletContext ->

		if(!Person.count()){
			Comment c1 = new Comment(message:"have a safe journey :)")
			c1.save()
			Comment c2 = new Comment(message:"when ??")
			c2.save()
			Comment c3 = new Comment(message:"il be back...")
			c3.save()

			Status s1= new Status(message:"I am going home....")
			s1.save()
			s1.addToComments(c1)
			s1.addToComments(c2)
			s1.addToComments(c3)
			s1.save()

			def p1 = new Person(username:"trodri",fullname:"Tarsicius Rodrigues",password:"1",enabled:true)
			def p2 = new Person(username:"shipsha",fullname:"Shipali Sharma",password:"1",enabled:true)
			def p3 = new Person(username:"nissa",fullname:"Nisha Saxena",password:"1",enabled:true)

			p1.save()
			p1.addToStatuses(s1)
			p1.addToComments(c3)
			p1.save()

			p2.save()
			p2.addToComments(c1)
			p2.save()
			
			p3.save()
			p3.addToComments(c2)
			p3.save()
		}

	}
	def destroy = {
	}
}
