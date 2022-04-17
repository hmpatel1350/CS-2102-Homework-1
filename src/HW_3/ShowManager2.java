package HW_3;

import java.util.LinkedList;

class ShowManager2 {
	
	ShowManager2() {}

	/**
	 * Takes a list of shows and organizes them
	 * @param shows LinkedList of Shows
	 * @return HW_3.ShowSummary of shows placed into daytime, primetime, or latenight
	 *
	 * Task Order:
	 * 1. Create a new empty HW_3.ShowSummary (aka one with no shows currently stored in any LinkedList)
	 * 2. Loop through the list of shows and ignore any that are special
	 * 3. For all shows that aren't special, check the broadcast time and update the correct list in the HW_3.ShowSummary
	 * 4. Return the now filled HW_3.ShowSummary
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary summary = new ShowSummary();

		for(Show s: shows){
			if(!s.isSpecial){
				double time = s.broadcastTime;
				if(600<=time && time<1700)
					summary.daytime.add(s);
				else if(1700<=time && time<2200)
					summary.primetime.add(s);
				else if(time<1 || time>=10)
					summary.latenight.add(s);
			}
		}

		return summary;
	}
	
}
