
public class SimpleReflexAgent {

	

	public static void main(String[] args) 
	{
		Environment environment;
		
		//	Process command-line arguments
		if (args.length < 1)
		{
			System.out.println("Usage: java SimpleReflexAgent start-location roomA-status roomB-status");
			return;
		}
		else
		{
			int agentLocation = Integer.parseInt(args[0]);
			boolean rooms[] = new boolean[2];
			rooms[0] = Boolean.parseBoolean(args[1]);
			rooms[1] = Boolean.parseBoolean(args[2]); 
			
			environment = new Environment(agentLocation, rooms);
		}
		
		System.out.println("Agent Started...");
	

		
		for(int i=0; i<5; i++)
		{
			System.out.println("Environment Status:");
			System.out.println("\tAgent Location: " + environment.getAgentLocation());
			
			for (int locationIndex = 0; locationIndex < 2; locationIndex++)
			{
				System.out.print("\tLocation " + locationIndex + ": ");
				
				if (environment.getRooms()[locationIndex])
					System.out.println("Dirty");
				else
					System.out.println("Clean");
			}
			
			System.out.println();
			
			
			Percept percept = perceiveEnvironment(environment);
			
			AgentAction action = reflexVacuumAgent(percept);
			
			performAction(action, environment);
		}
	}

	
	private static Percept perceiveEnvironment(Environment environment)
	{
		//	TODO: Implement the code to examine the environment 
		//		  and returns a percept that the agent can reason about.
			int i = environment.getAgentLocation(); 
			boolean[] array = environment.getRooms();
			if(array[i]==true) {
				return new Percept(i, true);
			}
			else {
				return new Percept(i, false);
			}
			 
	}
	
	
	private static void performAction(AgentAction action, Environment environment)
	{
		
		// TODO: This method implements the agent's actuators, 
		//		 i.e., it performs a given action in the environment.
			int i = environment.getAgentLocation();
		
			switch (action) {
			case Clean :
				System.out.println("Action: Clean");
				boolean [] array = environment.getRooms();
				array[i] = false; 
				break;
			case MoveRight :
				System.out.println("Action: Move Right");
				environment.setAgentLocation(1);
				break;
			case MoveLeft :
				System.out.println("Action: Move Left");
				 i++; 
				 environment.setAgentLocation(0);
				break;
			default:
				break; 
				
			}
		
	}
	
	
	private static AgentAction reflexVacuumAgent(Percept percept)
	{
		int location = percept.getLocation();
		AgentAction action; 
		if(location ==0 && percept.isDirty()) {
			action = AgentAction.Clean;
		}
		else if (location == 0 && !percept.isDirty()) {
			action = AgentAction.MoveRight;
		}
		else if (location ==1 && percept.isDirty()) {
			action = AgentAction.Clean;
		}
		else if(location ==1&& !percept.isDirty()) {
			action = AgentAction.MoveLeft;
		}
		else {
			action = AgentAction.NoOp;
		}
		return action; 
	}

}