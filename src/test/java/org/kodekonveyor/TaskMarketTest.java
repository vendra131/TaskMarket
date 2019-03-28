package org.kodekonveyor;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class TaskMarketTest {

	@Test
	public void orgTest() {
		//There are organisations in the task market
		TaskMarket market = new TaskMarket();
		Collection<Organisation> orgs = market.getOrganisations();
		assertNotEquals(Collection.class, orgs.getClass());
	}

}
