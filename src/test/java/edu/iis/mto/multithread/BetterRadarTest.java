package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.concurrent.Executor;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest 
{
	@Rule
	public RepeatRule repeatRule = new RepeatRule();
	
	@Test
	@Repeat(times=100)
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
		verify(batteryMock,times(10)).launchPatriot();
	}
}
