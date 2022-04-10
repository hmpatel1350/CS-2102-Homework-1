import java.util.LinkedList;

class ShowManager1 {
	
	ShowManager1() {}

	/**
	 * Takes a list of shows and organizes them
	 * @param shows LinkedList of Shows
	 * @return ShowSummary of shows placed into daytime, primetime, or latenight
	 *
	 * Task Order:
	 * 1. Create LinkedLists of shows for daytime, primetime, and latenight
	 * 2. Loop through the list of shows and ignore any that are special
	 * 3. For all shows that aren't special, check the broadcast time and put them into the correct list
	 * 4. Create a new ShowSummary with the LinkedLists as parameters and return that ShowSummary
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> daytime = new LinkedList<>();
		LinkedList<Show> primetime = new LinkedList<>();
		LinkedList<Show> latenight = new LinkedList<>();

		for(Show s: shows){
			if(!s.isSpecial){
				double time = s.broadcastTime;
				if(600<=time && time<1700)
					daytime.add(s);
				else if(1700<=time && time<2200)
					primetime.add(s);
				else if(time<1 || time>=10)
					latenight.add(s);
			}
		}

		return new ShowSummary(daytime, primetime, latenight);
	}
	
}
