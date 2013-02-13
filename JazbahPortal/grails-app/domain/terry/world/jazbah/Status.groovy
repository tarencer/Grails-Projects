package terry.world.jazbah

class Status {

	String message
	Date dateCreated = new Date()
	static belongsTo=[createdBy:Person]
	static hasMany=[comments:Comment]
    static constraints = {
		message blank:false,size:1..300
    }
	
	String toString()
	{
		message
	}
}
