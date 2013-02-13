package terry.world.twitter
import terry.world.twitter.auth.Person

class StatusController {

	def springSecurityService

	def index = {
		def msgs = currentUserTimeLine()
		[messages:msgs]
	}

	def follow = {
		def per = Person.get(params.id)
		if(per)
		{
			def currPer = lookupPerson()
			currPer.addToFollowed(per)
			currPer.save()
		}
		redirect action:'index'
	}

	def updateStatus = {
		def status = new Status(message: params.message)
		status.author = lookupPerson()
		status.save()
		def messages = currentUserTimeLine()
		render template:'messages', collection: messages, var:'message'
	}
	private currentUserTimeLine()
	{
		def per = lookupPerson()
		def messages = Status.withCriteria {
			or{
				author{
					eq 'username',per.username
				}
				if(per.followed)
				{
					inList 'author',per.followed
				}
			}
			maxResults 10
			order 'dateCreated','desc'
		}
		messages
	}
	private lookupPerson(){
		Person.get(springSecurityService.principal.id)
//		springSecurityService.currentUser
	}
}
