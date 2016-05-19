package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

import org.junit.Test;

public class RadarTest 
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
		Radar radar = new Radar(batteryMock, executor);
		radar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}

}
