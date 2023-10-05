package chapter2.agent_AB;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
		if(p.getLocationState()==p.getLocationState().DIRTY) 
			return Environment.SUCK_DIRT;
		 if(p.getLocation().equals(Environment.LOCATION_A)) {
			return Environment.MOVE_RIGHT;
		} else if(p.getLocation().equals(Environment.LOCATION_B)) {
			return Environment.MOVE_LEFT;
		} else return NoOpAction.NO_OP;
		
		
	}
}