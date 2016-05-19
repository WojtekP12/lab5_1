package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class Radar 
{
	private PatriotBattery battery;
	private Executor executor;
	
	public Radar(PatriotBattery missle, Executor executor) 
	{
		this.battery = missle;
		this.executor = executor;
	}

	public void notice(Scud enemyMissle) 
	{
		launchPatriot();
	}

	private void launchPatriot() 
	{
		Runnable launchPatriotTask = new Runnable() 
		{
			public void run() 
			{
				for (int i = 0; i < 10; i++) 
				{
					battery.launchPatriot();
				}
			}
		};

		executor.execute(launchPatriotTask);
	}
}
