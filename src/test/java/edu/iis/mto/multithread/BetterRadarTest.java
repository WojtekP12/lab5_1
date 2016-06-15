package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

import org.junit.Test;

public class BetterRadarTest 
{
	@Test
	public void launchPatriotOnceWhenNoticesAScudMissle()
	{
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		
		Executor executor = new Executor()
				{
					@Override
					public void execute(Runnable command)
					{
						command.run();
					}
				};
		BetterRadar betterRadar = new BetterRadar(batteryMock, executor);
		betterRadar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}
}
