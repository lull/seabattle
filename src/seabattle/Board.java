/*import java.util.Collection;

public class Board {
	Collection<Ship> ships;
	
	public Deck getDeckAt(Location location) {
		for (Ship ship : ships) {
  			for (Deck deck : ship.getDecks()) {
  				if (deck.getLocation().equals(location)) {
  					return deck;
  				}
  			}
  		}	
	}
	
  	public CellType getCellType(int x, int y) {
  		Location location = new Location(x, y);
  		Deck deck = getDeckAt(location);
  		if (deck != null) {
  			if (deck.getShip().isDead())
  				return CellType.DEAD;
  			else if (deck.isPadded())
  				return CellType.WOUNDED;
  			else
  				return CellType.HEALTHY;
  		} else {
  			return CellType.EMPTY;
  		}
  	}
}
*/