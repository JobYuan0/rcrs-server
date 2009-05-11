package rescuecore2.version0.messages;

import java.util.Collection;
import java.util.List;

import rescuecore2.messages.AbstractMessage;

import rescuecore2.version0.entities.RescueObject;

/**
   A message for signalling a perception update for an agent.
 */
public class KASense extends AbstractMessage {
    private IntComponent agentID;
    private IntComponent time;
    private EntityListComponent updates;

    /**
       An empty KASense message.
     */
    public KASense() {
        super("KA_SENSE", MessageConstants.KA_SENSE);
        agentID = new IntComponent("Agent ID");
        time = new IntComponent("Time");
        updates = new EntityListComponent("Updates");
        addMessageComponent(agentID);
        addMessageComponent(time);
        addMessageComponent(updates);
    }

    /**
       A populated KASense message.
       @param agentID The ID of the Entity that is receiving the update.
       @param time The timestep of the simulation.
       @param updates All Entities that the agent can perceive.
     */
    public KASense(int agentID, int time, Collection<RescueObject> updates) {
        this();
        this.agentID.setValue(agentID);
        this.time.setValue(time);
        this.updates.setEntities(updates);
    }

    /**
       Get the ID of the agent.
       @return The agent ID.
     */
    public int getAgentID() {
        return agentID.getValue();
    }

    /**
       Get the time.
       @return The time.
     */
    public int getTime() {
        return time.getValue();
    }

    /**
       Get the updated entity list.
       @return All entities that have been updated.
     */
    public List<RescueObject> getUpdates() {
        return updates.getEntities();
    }
}