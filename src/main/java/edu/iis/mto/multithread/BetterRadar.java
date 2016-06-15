package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar 
{
	private PatriotBattery battery;
	private Executor executor;
	
	public BetterRadar(PatriotBattery missle, Executor executor) 
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
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 1; i++) 
				{
					battery.launchPatriot();
				}
			}
		});
	}
}
