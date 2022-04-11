import java.util.LinkedList;
import java.util.Objects;

class ShowSummary {
	
	LinkedList<Show> daytime;
	LinkedList<Show> primetime;
	LinkedList<Show> latenight;
	
	ShowSummary() 
	{
		this.daytime = new LinkedList<Show>();
		this.primetime = new LinkedList<Show>();
		this.latenight = new LinkedList<Show>();
	}
	
	ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight)
	{
		this.daytime = daytime;
		this.primetime = primetime;
		this.latenight = latenight;
	}

	/**
	 * Checks to see if two ShowSummary objects are equal
	 * @param o Object
	 * @return True if the two summaries are equal, false if they are not
	 * Criteria For Equal:
	 * 1. "Each pair of corresponding lists (ex. daytime in the first instance and daytime in the second instance)
	 *    have the same size."
	 * 2. "Each pair of corresponding lists have the same shows in the same order."
	 * 3. "A show in one list is considered the same as a show in the other list if only the title and broadcast time
	 * 	  of each show matches. It is NOT necessary that the two shows are the same object in memory or that the other
	 *    fields of the two shows match."
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		ShowSummary show = (ShowSummary) o;
		if(show.daytime.size()!=daytime.size() //Returns false if lengths are not equal
				|| primetime.size()!=show.primetime.size()
				|| latenight.size()!=show.latenight.size())
			return false;
		else{
			for(int i = 0; i<daytime.size(); i++){ //Returns false if shows not in same order
				Show s1 = daytime.get(i);
				Show s2 = show.daytime.get(i);
				if(!s1.title.equals(s2.title)||s1.broadcastTime!=s2.broadcastTime)
					return false;
			}
			for(int i = 0; i<primetime.size(); i++){ //Returns false if shows not in same order
				Show s1 = primetime.get(i);
				Show s2 = show.primetime.get(i);
				if(!s1.title.equals(s2.title)||s1.broadcastTime!=s2.broadcastTime)
					return false;
			}
			for(int i = 0; i<latenight.size(); i++){ //Returns false if shows not in same order
				Show s1 = latenight.get(i);
				Show s2 = show.latenight.get(i);
				if(!s1.title.equals(s2.title)||s1.broadcastTime!=s2.broadcastTime)
					return false;
			}
		}
		return true; //Returns true if all tests passed
	}

}
