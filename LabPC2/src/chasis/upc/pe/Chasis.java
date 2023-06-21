package chasis.upc.pe;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Chasis {
	
	public String cpus;
	public String memMax;
	public String memTotal;
	public String memLibre;
	public String tiempo;
	public String discoCTotal;
	public String discoCLibre;
	public String elapseTime;
	
	public Chasis(){
	
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		long start = System.nanoTime();
		Runtime runtime = Runtime.getRuntime();
		int cpus = runtime.availableProcessors();
		long mmax = runtime.maxMemory() / 1024 / 1024;
		long mtotal = runtime.totalMemory() / 1024 / 1024;
		long mfree = runtime.freeMemory() / 1024 / 1024;
		File cDrive = new File("C:");
		this.cpus=Integer.toString(cpus);
		this.memMax = Long.toString(mmax);
		this.memTotal = Long.toString(mtotal);
		this.memLibre = Long.toString(mfree);
		double elapseTime = (System.nanoTime() - start) / 1_000_000_000;
		this.tiempo = Double.toString(elapseTime);
		this.discoCTotal = Double.toString(cDrive.getTotalSpace() / 1073741824);
		this.discoCLibre = Double.toString(cDrive.getFreeSpace() / 1073741824);
	}

}
