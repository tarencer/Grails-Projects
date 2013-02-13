package terry.world.jazbah

class Comment {

	String message
	Date dateCreated= new Date()
//	static belongsTo = [status:Status,person:Person]
    static constraints = {
		message blank:false,size:1..300
    }
	String toString()
	{
		message
	}
	
}
