package terry.world.jazbah

class Person extends User {

	String fullname;
	Date dateCreated = new Date()
	static hasMany=[statuses:Status,comments:Comment]
    static constraints = {
		username blank:false,unique:true,size:2..15
		fullname blank:false
    }
	String toString(){
		fullname
	}
}
